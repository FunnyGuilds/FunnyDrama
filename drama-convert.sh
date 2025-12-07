#!/bin/bash

# Usage: ./drama-convert.sh [to-yaml|to-json]

ACTION="${1:-to-yaml}"

case "$ACTION" in
  to-yaml|yaml)
    if [ ! -f "drama.json" ]; then
      echo "Error: drama.json not found"
      exit 1
    fi

    echo "Converting drama.json → drama.yaml..."
    docker run --rm -v "$(pwd):/work" -w /work python:3.14-alpine sh -c '
pip install -q ruamel.yaml && python3 - <<EOF
import json
from ruamel.yaml import YAML
from ruamel.yaml.scalarstring import LiteralScalarString

with open("drama.json", "r") as f:
    data = json.load(f)

yaml = YAML()
yaml.preserve_quotes = False
yaml.default_flow_style = False
yaml.width = 4096

def force_literal_style(obj):
    if isinstance(obj, dict):
        return {k: force_literal_style(v) for k, v in obj.items()}
    elif isinstance(obj, list):
        return [force_literal_style(item) for item in obj]
    elif isinstance(obj, str) and "\n" in obj:
        return LiteralScalarString(obj)
    return obj

data = force_literal_style(data)

with open("drama.yaml", "w") as f:
    yaml.dump(data, f)

print("✓ Converted drama.json → drama.yaml")
print("Edit drama.yaml and run: ./drama-convert.sh to-json")
EOF
'
    ;;

  to-json|json)
    if [ ! -f "drama.yaml" ]; then
      echo "Error: drama.yaml not found"
      echo "Run: ./drama-convert.sh to-yaml first"
      exit 1
    fi

    echo "Converting drama.yaml → drama.json..."
    docker run --rm -v "$(pwd):/work" -w /work python:3.14-alpine sh -c '
pip install -q ruamel.yaml && python3 - <<EOF
import json
from ruamel.yaml import YAML

yaml = YAML()

with open("drama.yaml", "r") as f:
    data = yaml.load(f)

with open("drama.json", "w") as f:
    json.dump(data, f, indent=2, ensure_ascii=False)
    f.write("\n")

print("✓ Converted drama.yaml → drama.json")
EOF
'
    ;;

  *)
    echo "Usage: $0 [to-yaml|to-json]"
    echo ""
    echo "Examples:"
    echo "  $0 to-yaml    # Convert drama.json to drama.yaml for editing"
    echo "  $0 yaml       # Same as above (short form)"
    echo "  $0 to-json    # Convert drama.yaml back to drama.json"
    echo "  $0 json       # Same as above (short form)"
    echo "  $0            # Defaults to to-yaml"
    exit 1
    ;;
esac
