package github.fatec.com.spring.repository.mongo;

import github.fatec.com.spring.repository.orm.OrmMongoLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LoginRepositoryWithMongoDB extends MongoRepository<OrmMongoLogin, String> {

    Optional<OrmMongoLogin> findByUserName(String userName);
}