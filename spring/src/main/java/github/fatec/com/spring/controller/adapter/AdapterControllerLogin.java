package github.fatec.com.spring.controller.adapter;

import github.fatec.com.entity.Login;
import github.fatec.com.spring.controller.dto.request.RequestLogin;
import github.fatec.com.spring.controller.dto.response.ResponseLogin;

public class AdapterControllerLogin {
    public Login toDomain(RequestLogin request) {
        return new Login(null, request.userName(), request.password(), request.roles());
    }
    public ResponseLogin toResponse(Login login) {
        return new ResponseLogin(login.id(), login.userName(), login.roles());
    }
}