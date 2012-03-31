package uk.co.richardgoater.stats.tests.upload.dao;

import static org.easymock.EasyMock.createMock;

import org.junit.Before;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class DAOTest {

	protected HibernateTemplate mockHibernateTemplate;
	
	@Before
	public void setUp() {
		mockHibernateTemplate = createMock(HibernateTemplate.class);
		composeObjects();
		setExpectations();
	}
	
	protected abstract void composeObjects();
	
	protected abstract void setExpectations();

}
