package github.fatec.com.spring.config;

import github.fatec.com.repository.RepositoryLogin;
import github.fatec.com.spring.repository.LoginRepositoryImpl;
import github.fatec.com.spring.repository.mongo.LoginRepositoryWithMongoDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public RepositoryLogin RepositoryLogin(LoginRepositoryWithMongoDB mongoRepo) {
        return new LoginRepositoryImpl(mongoRepo);
    }
}