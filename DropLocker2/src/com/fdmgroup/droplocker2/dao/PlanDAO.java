package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.droplocker2.entities.Plan;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class PlanDAO extends Storage<Plan, Integer> {

	EntityManager em;

	@Override
	public Plan create(Plan plan) throws StorableNotFoundException,
			StorableNullException {
		
		if (plan!=null)		{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(plan);
			em.getTransaction().commit();
			em.close();
			return plan;
		}
		throw new StorableNullException("Attempeted to create plan of null value");
	}

	@Override
	public Plan read(Integer ID) throws StorableNotFoundException {
		em=emf.createEntityManager();
		Plan plan = em.find(Plan.class, ID);
		em.close();
		return plan;
	}

	@Override
	public Plan update(Plan oldPlan, Plan newPlan) throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldPlan != null && newPlan != null) {
			em.getTransaction().begin();
			Plan result = em.find(Plan.class, oldPlan.getPlanId());
			result.setFilesAllowed(newPlan.getFilesAllowed());
			result.setPlanName(newPlan.getPlanName());
			em.close();
			return result;
		} else
			throw new StorableNotFoundException(oldPlan.getPlanName()
					+ " was not found in our database");
	}

	@Override
	public void delete(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Plan.class, ID));
		em.getTransaction().commit();
		em.close();
	}

}
