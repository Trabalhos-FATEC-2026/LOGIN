package github.fatec.com.spring.controller.dto.response;

import java.util.List;

public record ResponseLogin(String id, String userName, java.util.List<String> roles) {}