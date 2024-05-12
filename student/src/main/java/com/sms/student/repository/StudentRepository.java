package com.sms.student.repository;

import com.sms.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long>{

    @Query("SELECT u FROM Student u WHERE u.name = ?1")
    Employee findStudentByName(String name);
}
