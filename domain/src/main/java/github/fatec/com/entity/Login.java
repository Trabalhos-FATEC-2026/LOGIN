package github.fatec.com.entity;

import java.util.List;

public record Login(
        String id,
        String userName,
        String password,
        List<String> roles) {

}