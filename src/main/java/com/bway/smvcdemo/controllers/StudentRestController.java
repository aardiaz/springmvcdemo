package com.bway.smvcdemo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bway.smvcdemo.daos.StudentDao;
import com.bway.smvcdemo.models.Student;


@RestController
@RequestMapping("api/rest")
public class StudentRestController {
	

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> index() {
		ResponseEntity<List<Student>> studList = 
new ResponseEntity<List<Student>>( studentDao.getAll(), HttpStatus.OK);
		return studList;
	}
}







