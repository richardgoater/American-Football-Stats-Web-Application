package uk.co.richardgoater.stats.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateDAO {

	protected HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public void setHibernateTemplate(HibernateTemplate ht) {
		hibernateTemplate = ht;
	}
}
