package net.funnyguilds.drama.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DramaDeclaration {
    private Map<String, List<String>> staticElements;
    private List<String> sentences;
}
