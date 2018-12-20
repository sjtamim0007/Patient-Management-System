package com.tamim.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tamim.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Doctor> getDoctors() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Doctor> theQuery = currentSession.createQuery("from Doctor order by name", Doctor.class);

		// execute query
		List<Doctor> doctors = theQuery.getResultList();

		return doctors;
	}

	@Override
	public void saveDoctor(Doctor theDoctor) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save/Update the patient
		currentSession.saveOrUpdate(theDoctor);
	}
	
	@Override
	public Doctor getDoctor(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Retrieve patient using primary key
		Doctor theDoctor = currentSession.get(Doctor.class, theId);

		return theDoctor;
	}
	
	@Override
	public void deleteDoctor(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Create query for deleting object with primary key
		Query theQuery = currentSession.createQuery("delete from Doctor where id=:doctorId");

		theQuery.setParameter("doctorId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Doctor> searchDoctor(String theSearchName) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Doctor> theQuery = null;

		// Only Search by name if the name is not empty
		if (!theSearchName.equals(null) && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Doctor where lower(name) like :theName", Doctor.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// theSearchName is empty ... so just get all patients
			theQuery = currentSession.createQuery("from Doctor", Doctor.class);
		}

		// Get the results
		List<Doctor> doctors = theQuery.getResultList();

		return doctors;
	}

}
