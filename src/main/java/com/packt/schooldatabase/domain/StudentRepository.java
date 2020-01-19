package com.packt.schooldatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    //Fetch users by surname
    List<Student> findBysurname(@Param("surname") String surname);
    //Fetch users by identity number
    List<Student> findByidentitynumber(@Param("identitynumber") String identitynumber);
}
