package com.abhitrio.configuration;

import com.abhitrio.configuration.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class PizzaAplication implements CommandLineRunner {

    private PizzaConfig pizzaConfig;

    public PizzaAplication(PizzaConfig pizzaConfig){
        this.pizzaConfig = pizzaConfig;
    }
    public static void main(String[] args) {
        SpringApplication.run(PizzaAplication.class, args);
    }

    @Override
    public void run(final String... args) {
//        final PizzaConfig pizzaConfig = new PizzaConfig(
//            "tomato", "morzarella", "thin"
//        );
        log.info(String.format("I want a %s crust pizza, with %s and %s sauce",pizzaConfig.getCrust(), pizzaConfig.getTopping(),pizzaConfig.getSauce()));
    }

}
