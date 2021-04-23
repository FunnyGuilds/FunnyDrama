package net.funnyguilds.drama.api

import net.funnyguilds.drama.config.DramaConfig
import net.funnyguilds.drama.provider.DramaProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors
import java.util.stream.IntStream

@RestController
@RequestMapping("/api/v1/drama")
class DramaController {

    @Autowired private lateinit var  dramaProvider: DramaProvider
    @Autowired private lateinit var dramaConfig: DramaConfig

    @RequestMapping
    fun drama(): ResponseEntity<*> {
        return ResponseEntity.ok(DramaDeclaration(dramaConfig.staticElements, dramaConfig.sentences))
    }

    @RequestMapping("/create")
    fun dramaCreate(): ResponseEntity<*> {
        return ResponseEntity.ok(DramaResponse(dramaProvider.create()))
    }

    @RequestMapping("/create/{dramas}")
    fun dramaCreateMultiple(@PathVariable dramas: Int): ResponseEntity<*> {
        return if (dramas < 1 || dramas > 100) {
            ResponseEntity.badRequest().body(DramaError("dramas should be between 1 and 100"))
        }
        else ResponseEntity.ok(IntStream.range(0, dramas)
            .mapToObj { a: Int -> DramaResponse(dramaProvider.create()) }
            .collect(Collectors.toList()))
    }
}