package com.fdmgroup.droplocker2.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.droplocker2.businesslogic.BeanSingleton;
import com.fdmgroup.droplocker2.entities.Plan;

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
	public void testCreatePlan() {
		dao = beans.getSpring().getBean("PlanDAO");
		dao.create(plan1);
	}

}
