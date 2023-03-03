package com.FullStackApp.WebServices.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Kullanıcı ile ilgili olacak bütün http requestlerinin ulaştığı class olacak
// bu sebeple
// @RestController notionını ekledim bu sayede spring bir takım ayarlamalar
// yapacak
public class UserController {
    // Restful web servis yazıyorum
    // Logluyorum. Belki belirli timestamplerde filelara yazabilirim bu logları.
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    // dependency injection: Uygulama çalıştığında spring usercontrollerı oluştururken
    // UserRepository dependencini görüp obje oluşturacak ve set edecek
    @Autowired
    UserService userService;

    //farklı portlar arasında iletişim kuruyorum CORS hatası almamak için 
    // @CrossOrigin diyerek özel headerları eklerim.
    // bu fonksiyonun bir post requestlerinde çalışmasını istiyorum.@PostMapping 'in
    // içerisine bizim dinlediğimiz
    // url pathini endpointmi veriyorum.
    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User user) {
        userService.save(user);
        log.info(user.toString());
    }
}
