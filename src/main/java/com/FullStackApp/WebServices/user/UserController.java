package com.FullStackApp.WebServices.user;

import com.FullStackApp.WebServices.error.ApiError;
import com.FullStackApp.WebServices.shared.GenericResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
// Kullanıcı ile ilgili olacak bütün http requestlerinin ulaştığı class olacak bu sebeple:
// @RestController notionını ekledim bu sayede spring bir takım ayarlamalar yapacak.
public class UserController {
    // Restful web servis yazıyorum
    // Logluyorum. Belki belirli timestamplerde filelara yazabilirim bu logları.
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    // dependency injection: Uygulama çalıştığında spring usercontrollerı oluştururken
    // UserRepository dependencini görüp obje oluşturacak ve set edecek
    @Autowired
    UserService userService;

    // farklı portlar arasında iletişim kuruyorum CORS hatası almamak için @CrossOrigin diyerek özel headerları eklerim.
    // bu fonksiyonun bir post requestlerinde çalışmasını istiyorum.@PostMapping 'in içerisine bizim dinlediğimiz
    // url pathini endpointmi veriyorum.
    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.save(user);
        GenericResponse response = new GenericResponse("user creation successful");

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // springe bu methodun bir exception handle olduğunu söyledim.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception) {
        ApiError error = new ApiError(400, "validation error", "/api/1.0/users");

        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);

        return error;
    }
}
