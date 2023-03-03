package com.FullStackApp.WebServices.user;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.PasswordCallback;


@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    // kendim constructer oluşturarak kendi dependency injectionumu yazmış oldum
    // spring user service oluştururken bu constructerı çağıracak.
    // Bu constructer da user repositorye ihtiyaç duyduğundan 9. satırda
    //    user repositoryi oluşturmuş olacak
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void save(User user) {
        String encryptedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

}
