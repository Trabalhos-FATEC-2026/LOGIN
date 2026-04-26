package github.fatec.com.repository;

import github.fatec.com.entity.Login;

import java.util.List;
import java.util.Optional;

public interface RepositoryLogin {

    Login save(Login login);

    Optional<Login> findById(String id);

    List<Login> findAll();

    Login update(String id, Login login);

    void delete(String id);

    Optional<Login> findByUserName(String userName);
}