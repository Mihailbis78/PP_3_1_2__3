package ru.kata.spring.boot_security.pp_3_1_2__3.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ru.kata.spring.boot_security.pp_3_1_2__3.Pp3123Application;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Pp3123Application.class);
    }
}


