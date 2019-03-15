package com.agilefaqs.dpw;

import static com.agilefaqs.dpw.Supervisor.NEW_LINE;
import static com.agilefaqs.dpw.WorkRequest.DEBUG_PRODUCT;
import static com.agilefaqs.dpw.WorkRequest.MEET_CLIENTS;
import static com.agilefaqs.dpw.WorkRequest.SIGN_INVOICE;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PerformJobTest {
	// Dmitri
	// |
	// Marci
	// / \
	// Todd Jordan
	// | |
	// Paul Joshua
	private final static Manager dmitri = new Manager("Dmitri", NoManager.getInstance());
	private final static Manager marci = new Manager("Marci", dmitri);
	private final static Entity todd = new Employee("Todd", marci);
	private final static Entity jordan = new Employee("Jordan", marci);
	private final static Entity paul = new Employee("Paul", todd);
	private final static Entity joshua = new Employee("Joshua", jordan);

	@Test
	public void employeeShouldPerformTheirWorkRequest() {
		assertEquals("Employee Joshua: PERFORMING task type=DEBUG_PRODUCT",
				joshua.handleRequest(DEBUG_PRODUCT));
	}

	@Test
	public void employeeRequestManagerToPerformTheirWorkRequest() {
		assertEquals(
				"Employee Joshua: FORWARDING task type=SIGN_INVOICE" + NEW_LINE
						+ "Employee Jordan: FORWARDING task type=SIGN_INVOICE"
						+ NEW_LINE
						+ "Manager Marci: PERFORMING task type=SIGN_INVOICE",
				joshua.handleRequest(SIGN_INVOICE));
	}

	@Test
	public void someTimesNoOneCanPerformWorkRequest() {
		assertEquals("Employee Paul: FORWARDING task type=MEET_CLIENTS"
				+ NEW_LINE + "Employee Todd: FORWARDING task type=MEET_CLIENTS"
				+ NEW_LINE + "Manager Marci: FORWARDING task type=MEET_CLIENTS"
				+ NEW_LINE
				+ "Manager Dmitri: FORWARDING task type=MEET_CLIENTS"
				+ NEW_LINE
				+ "No Entity present to handle task type=MEET_CLIENTS",
				paul.handleRequest(MEET_CLIENTS));
	}
}
