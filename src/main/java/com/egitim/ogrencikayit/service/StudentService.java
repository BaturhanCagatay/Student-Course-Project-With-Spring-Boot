	package com.egitim.ogrencikayit.service;
	
	import com.egitim.ogrencikayit.model.Course;
	import com.egitim.ogrencikayit.model.Student;
	import com.egitim.ogrencikayit.model.Enrollment;
	import com.egitim.ogrencikayit.repository.CourseRepository;
	import com.egitim.ogrencikayit.repository.StudentRepository;
	import com.egitim.ogrencikayit.repository.EnrollmentRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import java.util.List;
	
	@Service
	public class StudentService {
	
	    @Autowired
	    private StudentRepository studentRepository;
	
	    @Autowired
	    private CourseRepository courseRepository;
	
	    @Autowired
	    private EnrollmentRepository enrollmentRepository;
	
	    public void registerCourse(Long studentId, Long courseId) {
	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı"));
	
	        Course course = courseRepository.findById(courseId)
	                .orElseThrow(() -> new RuntimeException("Ders bulunamadı"));
	
	        student.getCourses().add(course);
	        studentRepository.save(student);
	    }
	
	    public void registerCourseByName(String studentName, String courseName) {
	        // Öğrenci varsa getir, yoksa oluştur
	        Student student = studentRepository.findByName(studentName)
	                .orElseGet(() -> {
	                    Student newStudent = new Student();
	                    newStudent.setName(studentName);
	                    return studentRepository.save(newStudent);
	                });

	        // Ders varsa getir, yoksa oluştur
	        Course course = courseRepository.findByName(courseName)
	                .orElseGet(() -> {
	                    Course newCourse = new Course();
	                    newCourse.setName(courseName);
	                    return courseRepository.save(newCourse);
	                });

	        // Kayıt varsa tekrar etme
	        boolean alreadyEnrolled = enrollmentRepository.existsByStudentAndCourse(student, course);
	        if (alreadyEnrolled) {
	            throw new RuntimeException("Zaten bu derse kayıtlı.");
	        }

	        Enrollment enrollment = new Enrollment();
	        enrollment.setStudent(student);
	        enrollment.setCourse(course);
	        enrollmentRepository.save(enrollment);
	    }
	
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }
	
	    public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }
	    public List<Enrollment> getAllEnrollments() {
	        return enrollmentRepository.findAll();
	    }
	}
