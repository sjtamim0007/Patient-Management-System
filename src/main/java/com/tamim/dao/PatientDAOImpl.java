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
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Patient> theQuery = currentSession.createQuery("from Patient order by name", Patient.class);

		// execute query
		List<Patient> patients = theQuery.getResultList();

		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save/Update the patient
		currentSession.saveOrUpdate(thePatient);
	}

	@Override
	public Patient getPatient(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Retrieve patient using primary key
		Patient thePatient = currentSession.get(Patient.class, theId);
		
		
		return thePatient;
	}

}
