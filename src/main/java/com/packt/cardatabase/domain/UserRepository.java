package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //Fetch users by surname
    List<User> findBysurname(@Param("surname") String surname);
    //Fetch users by identity number
    List<User> findByidentitynumber(@Param("identitynumber") String identitynumber);
}
