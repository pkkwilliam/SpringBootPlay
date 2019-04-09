package com.william.SpringBootPlay;

import com.william.SpringBootPlay.component.Engine;
import com.william.SpringBootPlay.interceptor.InterceptorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ComponentScan("com.william.SpringBootPlay.component")
@EnableCaching
@SpringBootApplication
@RestController
public class SpringBootPlayApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlayApplication.class, args);
        System.out.println(Engine.name);
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new InterceptorController());
        interceptorRegistration.excludePathPatterns("/login/**");
    }

    void print(String message) {
        System.out.println("Going to Return: "+message);
    }

    @GetMapping("/user")
    public UserDetail getUser() throws InterruptedException {
	    Thread.sleep(1000);
	    UserDetail response = new UserDetail(1,"dude1");
	    print(response.toString());
	    return new UserDetail(1,"dude1");
    }

    @GetMapping("/users")
    public List<UserDetail> getUsers() throws InterruptedException {
	    List<UserDetail> users = new ArrayList<>();
        Thread.sleep(1000);
        Random random = new Random();
        int length = random.nextInt() % 9 + 9;
        for (int i = 0; i < length; i++) {
            users.add(new UserDetail(random.nextInt(), "Dude:" + random.nextInt()));
        }
        print(users.toString());
        return users;
    }

}

class UserDetail {
    private int id;
    private String name;

    public UserDetail() {
    }

    public UserDetail(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

