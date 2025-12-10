package org.wk.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main application class for the repository service.
 * Bootstraps the Spring Boot application and configures beans.
 *
 * @author wangkang@yinhai.com
 * @date 2025年12月10日
 */
@SpringBootApplication
public class RepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }

    /**
     * Creates and configures a RestTemplate bean for making HTTP requests.
     *
     * @return a new RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
