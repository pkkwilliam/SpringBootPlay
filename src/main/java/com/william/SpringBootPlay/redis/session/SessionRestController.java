package com.william.SpringBootPlay.redis.session;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Author: Ka Kei Pun
 * Date: 3/1/19
 * Version: 1.0.0
 */

@RestController
@RequestMapping(path = "/session")
@EnableRedisHttpSession
public class SessionRestController {

    @GetMapping
    public String getUid(HttpSession httpSession) {
        UUID uuid = (UUID) httpSession.getAttribute("uuid");
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        httpSession.setAttribute("uuid", uuid);
        return uuid.toString();
    }

}
