package github.fatec.com.spring.repository;

import github.fatec.com.entity.Login;
import github.fatec.com.repository.RepositoryLogin;
import github.fatec.com.spring.repository.adapter.AdapterRepositoryLogin;
import github.fatec.com.spring.repository.mongo.LoginRepositoryWithMongoDB;

import java.util.List;
import java.util.Optional;

public class LoginRepositoryImpl implements RepositoryLogin {

    private final LoginRepositoryWithMongoDB mongoRepo;
    private final AdapterRepositoryLogin adapter = new AdapterRepositoryLogin();

    public LoginRepositoryImpl(LoginRepositoryWithMongoDB mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Login save(Login login) {
        var orm = adapter.toOrm(login);
        return adapter.toDomain(mongoRepo.save(orm));
    }

    @Override
    public Optional<Login> findById(String id) {
        return mongoRepo.findById(id)
                .map(adapter::toDomain);
    }

    @Override
    public List<Login> findAll() {
        return mongoRepo.findAll()
                .stream()
                .map(adapter::toDomain)
                .toList();
    }

    @Override
    public Login update(String id, Login login) {
        var loginComId = new Login(
                id,
                login.userName(),
                login.password(),
                login.roles()
        );

        var orm = adapter.toOrm(loginComId);
        return adapter.toDomain(mongoRepo.save(orm));
    }

    @Override
    public void delete(String id) {
        mongoRepo.deleteById(id);
    }

    @Override
    public Optional<Login> findByUserName(String userName) {
        return mongoRepo.findByUserName(userName)
                .map(adapter::toDomain);
    }
}