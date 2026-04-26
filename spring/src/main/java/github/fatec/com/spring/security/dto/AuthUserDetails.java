    package github.fatec.com.spring.security.dto;


    import github.fatec.com.entity.Login;
    import org.springframework.security.core.*;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;

    import java.util.Collection;

    public record AuthUserDetails(Login login) implements UserDetails {

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return login.roles().stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .toList();
        }

        @Override
        public String getPassword() {
            return login.password();
        }

        @Override
        public String getUsername() {
            return login.userName();
        }

        @Override public boolean isAccountNonExpired() { return true; }
        @Override public boolean isAccountNonLocked() { return true; }
        @Override public boolean isCredentialsNonExpired() { return true; }
        @Override public boolean isEnabled() { return true; }
    }