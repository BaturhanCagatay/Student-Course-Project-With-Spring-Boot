package com.egitim.ogrencikayit.repository;

import com.egitim.ogrencikayit.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByName(String name);
}