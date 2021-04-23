package net.funnyguilds.drama.config

import eu.okaeri.configs.ConfigManager
import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.hjson.HjsonConfigurer
import eu.okaeri.configs.validator.okaeri.OkaeriValidator
import org.springframework.stereotype.Service
import java.io.File

@Service
class ConfigurationFactory {

    fun <T : OkaeriConfig?> createAndLoadConfig(clazz: Class<T>?, bindFile: File?): T {
        return ConfigManager.create(clazz) { it: OkaeriConfig ->
            it.withConfigurer(OkaeriValidator(HjsonConfigurer(), true))
            it.withBindFile(bindFile)
            it.saveDefaults()
            it.load(true)
        }
    }
}
