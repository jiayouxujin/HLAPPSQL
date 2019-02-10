package com.xxx.demo;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.autoconfigure.domain.EntityScan;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = { "com.xxx.demo.Controller" })
@EnableJpaRepositories(basePackages = {"com.xxx.demo.Repository"})
@EntityScan(basePackages = {"com.xxx.demo.Entity"})
@ComponentScan(basePackages = {"com.xxx.demo.Service"})

@SpringBootApplication
public class HLAPPSQLApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HLAPPSQLApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(HLAPPSQLApplication.class, args);
    }
}
