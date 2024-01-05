package com.abhitrio.configuration.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza") // this helsp to look for values stored in .properties or .yml file
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaConfig {

    private  String sauce;
    private String topping;
    private String crust;
}
