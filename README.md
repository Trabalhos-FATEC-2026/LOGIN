# 📋 API Documentation

---

## 🔐 Autenticação

### Cadastrar Usuário

```
POST http://localhost:8080/login
```

```json
{
  "userName": "Rodrigo",
  "password": "12345",
  "roles": ["ADMIN"]
}
```

---

### Fazer Login

```
POST http://localhost:8080/auth/login
```

```json
{
  "userName": "Rodrigo",
  "password": "12345"
}
```

> ⚠️ Pegar valor do Bearer token no terminal e colar em Authorization, Auth Type: **Bearer Token**.
