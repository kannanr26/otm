package com.otm.core.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateSession {

	private static SessionFactory hibernateFactory;

	@Autowired
	public HibernateSession(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		hibernateFactory = factory.unwrap(SessionFactory.class);
	}

	static public Session getNewSession() {
		return hibernateFactory.getCurrentSession();
	}

}
