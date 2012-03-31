package uk.co.richardgoater.stats.tests;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	protected static ApplicationContext context;

	@BeforeClass
	public static void setupBeforeClass() {
		context = new ClassPathXmlApplicationContext("uk/co/richardgoater/stats/tests/Spring-test.xml");
	}
}
