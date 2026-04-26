package github.fatec.com.spring.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "login")
public record OrmMongoLogin(
        @Id String id,
        String userName,
        String password,
        List<String> roles
) {}