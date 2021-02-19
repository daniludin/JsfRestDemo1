package com.howtodoinjava.hibernate.test;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import com.howtodoinjava.hibernate.test.dto.EmployeeEntity;

@ManagedBean
public class EmployeeBean {
	private String firstname;
	private String lastname;
	private String email;
	
    public void createEmployee(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail(getEmail());
		emp.setFirstName(getFirstname());
		emp.setLastName(getEmail());
		
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
