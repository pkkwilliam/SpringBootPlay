package com.william.SpringBootPlay.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Ka Kei Pun
 * Date: 3/3/19
 * Version: 1.0.0
 */

@Configuration
public class ComponentConfiguration {

    @Bean
    public Engine getEngine() {
        return new Engine("haha");
    }

}
