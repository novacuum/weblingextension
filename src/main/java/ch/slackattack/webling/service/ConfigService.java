package ch.slackattack.webling.service;

import ch.slackattack.webling.repo.Config;
import ch.slackattack.webling.repo.ConfigRepository;
import dev.hilla.Nonnull;

public class ConfigService {
    private ConfigRepository repository;
    private Config config;

    public ConfigService(ConfigRepository repository) {
        this.repository = repository;
    }

    public Config save(Config config) {
        this.config = repository.save(config);
        return this.config;
    }

    @Nonnull
    protected Config getFromRepo() {
        var res = repository.findAll();

        if (res.isEmpty()) {
            return new Config();
        }

        return res.get(0);
    }

    @Nonnull
    public Config get() {
        if (config == null) {
            config = getFromRepo();
        }
        return config;
    }

    public String toString() {
        return config.host;
    }
}
