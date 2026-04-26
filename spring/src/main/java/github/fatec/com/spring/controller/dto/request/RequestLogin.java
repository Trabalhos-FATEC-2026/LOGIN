package github.fatec.com.spring.controller.dto.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public record RequestLogin(String userName, String password, java.util.List<String> roles) {}