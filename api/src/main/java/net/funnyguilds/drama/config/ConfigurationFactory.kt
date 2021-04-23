package net.funnyguilds.drama.config;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.hjson.HjsonConfigurer;
import eu.okaeri.configs.validator.okaeri.OkaeriValidator;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ConfigurationFactory {

    public <T extends OkaeriConfig> T createAndLoadConfig(Class<T> clazz, File bindFile) {
        return ConfigManager.create(clazz, (it) -> {
            it.withConfigurer(new OkaeriValidator(new HjsonConfigurer(), true));
            it.withBindFile(bindFile);
            it.saveDefaults();
            it.load(true);
        });
    }
}
