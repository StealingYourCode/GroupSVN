package com.fdmgroup.droplocker2.dao.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.droplocker2.businesslogic.BeanSingleton;
import com.fdmgroup.droplocker2.dao.Storage;
import com.fdmgroup.droplocker2.entities.Plan;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class PlanDAOtest {
	
	Storage dao;
	Plan plan, plan1, plan2;
	BeanSingleton beans;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		plan1 = (Plan) beans.getSpring().getBean("bronze");
		plan2 = (Plan) beans.getSpring().getBean("bronze");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreatePlan() throws StorableNotFoundException, StorableNullException {
		dao = (Storage) beans.getSpring().getBean("PlanDAO");
		dao.create(plan1);
	}

}
