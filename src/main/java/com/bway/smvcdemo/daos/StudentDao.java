package com.bway.smvcdemo.daos;

import java.util.List;

import com.bway.smvcdemo.models.Student;

public interface StudentDao {

	public List<Student> getAll();
	
	public Long insert(Student student);
	
	public void inserUpdate(Student student);
	
	public void edit(Long id);
	
	public void delete(Long id);
	
	public Student get(Long id);
}
