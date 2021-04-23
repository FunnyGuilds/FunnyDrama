/**
 * FunnyDrama
 * Copyright (C) 2021  Okaeri, Dawid Sawicki
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.funnyguilds.drama.api

import net.funnyguilds.drama.config.DramaConfig
import net.funnyguilds.drama.provider.DramaProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/drama")
class DramaController {

    @Autowired private lateinit var dramaProvider: DramaProvider
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
        } else ResponseEntity.ok((0 until dramas)
            .map { DramaResponse(dramaProvider.create()) }
            .toList()
        )
    }
}
