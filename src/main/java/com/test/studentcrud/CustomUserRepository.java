package com.test.studentcrud;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
}
