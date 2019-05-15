package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.student");
		Query query = em.createNativeQuery(sb.toString(), Student.class);
		List<Student> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = em.find(Student.class, code);
		return student;
	}

}
