package com.FullStackApp.WebServices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    // kendim constructer oluşturarak kendi dependency injectionumu yazmış oldum
    // spring user service oluştururken bu constructerı çağıracak.
    // Bu constructer da user repositorye ihtiyaç duyduğundan 9. satırda
    //    user repositoryi oluşturmuş olacak
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

}
