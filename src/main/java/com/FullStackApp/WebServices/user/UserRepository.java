package com.FullStackApp.WebServices.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository bizim database'e erişmemizle ilgili birkaç standart fonksiyonu barındıran bir interface
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByDisplayName(String username);
}
