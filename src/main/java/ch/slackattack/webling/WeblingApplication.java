package ch.slackattack.webling;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import ch.slackattack.webling.repo.ConfigRepository;
import ch.slackattack.webling.service.ConfigService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "hilla-todo")
public class WeblingApplication implements AppShellConfigurator {
	public static void main(String[] args) {
		SpringApplication.run(WeblingApplication.class, args);
	}

	@Bean
	public ConfigService exampleBean(ConfigRepository configRepository) {
		return new ConfigService(configRepository);
	}
}
