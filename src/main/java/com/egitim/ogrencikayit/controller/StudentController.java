package com.egitim.ogrencikayit.controller;

import com.egitim.ogrencikayit.model.Enrollment;
import com.egitim.ogrencikayit.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String registerToCourse(
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            Model model) {

        studentService.registerCourse(studentId, courseId);

        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", studentService.getAllCourses());
        model.addAttribute("message", "✅ Ders kaydı başarılı!");
        
        return "form"; 
    }

    @PostMapping("/register-by-name") // ← düzeltilmiş hali
    public String registerByName(
            @RequestParam String studentName,
            @RequestParam String courseName,
            Model model) {

        studentService.registerCourseByName(studentName, courseName);

        model.addAttribute("message", "✅ Başarıyla eklendi!");
        return "register-by-name";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", studentService.getAllCourses());
        return "form";
    }
    @GetMapping("/enrollments")
    public String showAllEnrollments(Model model) {
        List<Enrollment> enrollments = studentService.getAllEnrollments();
        model.addAttribute("enrollments", enrollments);
        return "enrollments";
    }
}