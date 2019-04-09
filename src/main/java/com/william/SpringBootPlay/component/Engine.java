package com.william.SpringBootPlay.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Author: Ka Kei Pun
 * Date: 3/3/19
 * Version: 1.0.0
 */

public class Engine {

    public static String name ;

    Engine(String name) {
        this.name = name;
    }

}