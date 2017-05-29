package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.context.support.UiApplicationContextUtils;

public class TAEVariosInteresesTest {
	
	private TAEVariosIntereses tae;
	
	@Before
	public void setUp() throws Exception {
		tae = new TAEVariosIntereses();
	}

	@Test
	public void testIntereses() {
		assertNull(tae.getIntereses());
		tae.setIntereses(new ArrayList<InteresVariable>());
		assertThat(tae.getIntereses().size(), is(0));
	}

	@Test
	public void testPeriodo() {
		assertThat(tae.getPeriodo(), is(0));
		tae.setPeriodo(8);
		assertThat(tae.getPeriodo(), is(8));
	}


}
