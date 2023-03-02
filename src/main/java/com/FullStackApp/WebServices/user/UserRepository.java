package com.FullStackApp.WebServices.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	// JpaRepository bizim database'e erişmemizle ilgili birkaç standart fonksiyonu barındıran bir interface
	
}
