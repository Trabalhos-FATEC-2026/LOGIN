package github.fatec.com.spring.repository.adapter;

import github.fatec.com.entity.Login;
import github.fatec.com.spring.repository.orm.OrmMongoLogin;

public class AdapterRepositoryLogin {

    public OrmMongoLogin toOrm(Login login) {
        return new OrmMongoLogin(
                login.id(),
                login.userName(),
                login.password(),
                login.roles()
        );
    }

    public Login toDomain(OrmMongoLogin orm) {
        return new Login(
                orm.id(),
                orm.userName(),
                orm.password(),
                orm.roles()
        );
    }
}