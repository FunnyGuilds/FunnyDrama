package net.funnyguilds.drama.api;

import net.funnyguilds.drama.config.DramaConfig;
import net.funnyguilds.drama.provider.DramaProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/drama")
public class DramaController {

    @Autowired private DramaProvider dramaProvider;
    @Autowired private DramaConfig dramaConfig;

    @RequestMapping
    public ResponseEntity drama() {
        return ResponseEntity.ok(new DramaDeclaration(this.dramaConfig.getStaticElements(), this.dramaConfig.getSentences()));
    }

    @RequestMapping("/create")
    public ResponseEntity dramaCreate() {
        return ResponseEntity.ok(new DramaResponse(this.dramaProvider.create()));
    }

    @RequestMapping("/create/{dramas}")
    public ResponseEntity dramaCreateMultiple(@PathVariable int dramas) {

        if ((dramas < 1) || (dramas > 100)) {
            return ResponseEntity.badRequest().body(new DramaError("dramas should be between 1 and 100"));
        }

        return ResponseEntity.ok(IntStream.range(0, dramas)
                .mapToObj((a) -> new DramaResponse(this.dramaProvider.create()))
                .collect(Collectors.toList()));
    }
}
