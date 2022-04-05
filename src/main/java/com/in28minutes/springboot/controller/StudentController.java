package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	@SuppressWarnings("unused")
	private URI location;
	
	@GetMapping("/students/{studentId}/courses")
	public Course retrieveCourseForStudent(@PathVariable String studentId,
			@PathVariable String courseId){
		return studentService.retrieveCourse(studentId, courseId);
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}
	
	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable String studentId,
			@RequestBody Course newCourse){
		Course course = studentService.addCourse(studentId, newCourse);
		if(course == null)
			return ResponseEntity.noContent().build();
		
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Course.getId()).toUri();
		return null;
	}
}
