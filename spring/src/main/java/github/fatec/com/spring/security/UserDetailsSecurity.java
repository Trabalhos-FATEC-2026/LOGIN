package github.fatec.com.spring.security;


import github.fatec.com.repository.RepositoryLogin;
import github.fatec.com.spring.security.dto.AuthUserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurity implements UserDetailsService {

    private final RepositoryLogin repository;

    public UserDetailsSecurity(RepositoryLogin repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUserName(username)
                .map(AuthUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}