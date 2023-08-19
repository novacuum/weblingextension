package ch.slackattack.webling.repo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "config")
public class Config {
    @Id
    @GeneratedValue
    public Integer id;

    @NotBlank
    public String host;

    @NotBlank
    public String apiKey;
}
