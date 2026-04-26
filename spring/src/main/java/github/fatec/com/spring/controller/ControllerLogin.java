package github.fatec.com.spring.controller;

import github.fatec.com.repository.RepositoryLogin;
import github.fatec.com.spring.controller.adapter.AdapterControllerLogin;
import github.fatec.com.spring.controller.dto.request.RequestLogin;
import github.fatec.com.spring.controller.dto.response.ResponseLogin;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class ControllerLogin {

    private final RepositoryLogin repository;
    private final AdapterControllerLogin adapter = new AdapterControllerLogin();
    private final PasswordEncoder passwordEncoder;

    public ControllerLogin(RepositoryLogin repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseLogin create(@RequestBody RequestLogin request) {

        // 🔐 criptografa senha (ESSENCIAL)
        var login = adapter.toDomain(request);
        var loginComSenhaCriptografada = new github.fatec.com.entity.Login(
                login.id(),
                login.userName(),
                passwordEncoder.encode(login.password()),
                login.roles()
        );

        return adapter.toResponse(repository.save(loginComSenhaCriptografada));
    }

    @GetMapping
    public String getLogin() {
        return "Realizar Login";
    }

    @PutMapping("/{id}")
    public ResponseLogin update(@PathVariable String id,
                                @RequestBody RequestLogin request) {

        var login = adapter.toDomain(request);


        var loginAtualizado = new github.fatec.com.entity.Login(
                id,
                login.userName(),
                passwordEncoder.encode(login.password()),
                login.roles()
        );

        return adapter.toResponse(repository.update(id, loginAtualizado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}