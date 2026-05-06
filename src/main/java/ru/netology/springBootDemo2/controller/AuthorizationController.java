package ru.netology.springBootDemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springBootDemo2.exeption.InvalidCredentials;
import ru.netology.springBootDemo2.exeption.UnauthorizedUser;
import ru.netology.springBootDemo2.model.Authorities;
import ru.netology.springBootDemo2.service.AuthorizationService;

import java.util.List;

/*

Шаг 4. Теперь, когда весь код у вас готов, вам нужно написать обработчики ошибок, которые выкидывает сервис AuthorizationService.

Требования к обработчикам ошибок:

    на InvalidCredentials он должен отсылать обратно клиенту HTTP-статус с кодом 400 и телом в виде сообщения из exception;
    на UnauthorizedUser он должен отсылать обратно клиенту HTTP-статус с кодом 401 и телом в виде сообщения из exception и писать в консоль сообщение из exception.

*/

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
