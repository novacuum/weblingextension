package ch.slackattack.webling.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import ch.slackattack.webling.repo.Config;
import ch.slackattack.webling.repo.ConfigRepository;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConfigServiceTest {

  @Mock
  private ConfigRepository repository;

  private ConfigService configService;

  @BeforeEach
  public void setup() {
    this.configService = new ConfigService(repository);
  }

  @Test
  public void shouldSave() {
    // Initialize test config
    Config config = createTestConfig();

    // Mock repository to return test config
    when(repository.save(config)).thenReturn(config);

    // Call service method
    Config savedConfig = configService.save(config);

    // Assert config was saved
    assertNotNull(savedConfig);
    assertEquals(config.apiKey, savedConfig.apiKey);
    assertEquals(config.host, savedConfig.host);
  }

  @Test
  public void shouldGet() {
    // Initialize test config
    Config expectedConfig = createTestConfig();

    // Mock repository to return test config
    when(repository.findAll()).thenReturn(Arrays.asList(expectedConfig));

    // Call service method
    Config actualConfig = configService.get();

    // Assert config returned matches expected
    assertNotNull(actualConfig);
    assertEquals(expectedConfig, actualConfig);
    assertEquals(expectedConfig.apiKey, actualConfig.apiKey);
  }

  @Test
  public void shouldToString() {
    Config config = createTestConfig();

    // Mock repository to return test config
    when(repository.save(config)).thenReturn(config);

    configService.save(config);

    // Act
    String actualValue = configService.toString();

    // Assert
    assertNotNull(actualValue);
    assertTrue(actualValue.contains("test-host"));
  }

  protected Config createTestConfig() {
    Config config = new Config();
    config.apiKey = "test-api-key";
    config.host = "test-host";
    return config;
  }
}
