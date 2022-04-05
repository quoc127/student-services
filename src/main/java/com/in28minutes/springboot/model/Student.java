package com.in28minutes.springboot.model;

import java.util.List;

public class Student {
	private static String id;
	private String name;
	private String description;
	private List<Course> courses;
	private Object course;
	
	public  Student(String id, String name, String description, List<Course> course) {
		super();
		Student.id = id;
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		Student.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getNam() {
		return name;
	}

	public List<Course> getCourses() {
		return getCourses();
	}

	public void setCourses(List<Course> courses) {
	}
	
	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s, description=%s, steps=%s]",id,name,description,course);
	}

}
