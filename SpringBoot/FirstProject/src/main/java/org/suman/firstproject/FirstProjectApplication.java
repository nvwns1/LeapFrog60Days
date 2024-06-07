package org.suman.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {
        //traditional way
//        Dev dev = new Dev();
//        dev.build();

        // Creating IoC Container
        ApplicationContext context =
                SpringApplication.run(FirstProjectApplication.class, args);


        // Dependency Injection
        Dev obj = context.getBean(Dev.class);
        obj.build();

    }

}
