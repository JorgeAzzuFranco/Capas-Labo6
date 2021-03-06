package com.uca.capas.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Student;

public interface StudentDAO {
	List<Student> findAll() throws DataAccessException;
	Student findOne(Integer code) throws DataAccessException;
	
}
