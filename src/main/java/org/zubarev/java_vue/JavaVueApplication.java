package org.zubarev.java_vue;

import lombok.extern.jbosslog.JBossLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
public class JavaVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaVueApplication.class, args);
    }

}
