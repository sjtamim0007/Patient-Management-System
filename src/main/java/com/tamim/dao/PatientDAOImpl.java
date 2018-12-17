package com.tamim.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tamim.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> getPatients() {
		//get current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		
		Query<Patient> theQuery = currentSession.createQuery("from Patient", Patient.class);
		
		//execute query
		
		List<Patient> patients = theQuery.getResultList();
		
		return patients;
	}

}
