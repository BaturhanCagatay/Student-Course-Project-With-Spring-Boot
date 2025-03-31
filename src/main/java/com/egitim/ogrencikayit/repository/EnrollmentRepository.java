package com.egitim.ogrencikayit.repository;

import com.egitim.ogrencikayit.model.Course;
import com.egitim.ogrencikayit.model.Enrollment;
import com.egitim.ogrencikayit.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	boolean existsByStudentAndCourse(Student student, Course course);
}