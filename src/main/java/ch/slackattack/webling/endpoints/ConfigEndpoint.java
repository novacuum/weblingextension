package ch.slackattack.webling.endpoints;

import com.vaadin.flow.server.auth.AnonymousAllowed;

import ch.slackattack.webling.repo.Config;

import ch.slackattack.webling.service.ConfigService;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;

@Endpoint
@AnonymousAllowed
public class ConfigEndpoint {
    private ConfigService configService;

    public ConfigEndpoint(ConfigService configService) {
        this.configService = configService;
    }

    public Config save(Config todo) {
        return configService.save(todo);
    }

    @Nonnull
    public Config get() {
        return configService.get();
    }
}
