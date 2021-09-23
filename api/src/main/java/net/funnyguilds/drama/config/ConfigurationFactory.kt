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
package net.funnyguilds.drama.config

import eu.okaeri.configs.ConfigManager
import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.hjson.HjsonConfigurer
import eu.okaeri.configs.validator.okaeri.OkaeriValidator
import org.springframework.stereotype.Service
import java.nio.file.Path
import kotlin.reflect.KClass

@Service
class ConfigurationFactory {

    fun <T : OkaeriConfig> createAndLoadConfig(kClass: KClass<T>, bindFile: Path): T {
        return ConfigManager.create(kClass.java).apply {
            this.withConfigurer(OkaeriValidator(HjsonConfigurer(), true))
            this.withBindFile(bindFile)
            this.saveDefaults()
            this.load(true)
        }
    }
}
