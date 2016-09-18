package com.aptmgmt.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-config-test.xml"})
@EnableTransactionManagement
@Transactional
public class AptMgmtConfigTestBase {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Before
	public void setupData() {
	EntityBuilderManager.setEntityManager(entityManager);
	}
	
	
	
	@After
	public void tearDown() {
	EntityBuilderManager.clearEntityManager();
	}
	
	public static class EntityBuilderManager {
		private static ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<EntityManager>();

		public static void setEntityManager(EntityManager entityManager) {
			entityManagerHolder.set(entityManager);
		}

		public static void clearEntityManager() {
			entityManagerHolder.remove();
		}

		public static EntityManager getEntityManager() {
			return entityManagerHolder.get();
		}
	}
}
