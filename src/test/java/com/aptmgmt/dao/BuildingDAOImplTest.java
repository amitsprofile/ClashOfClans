package com.aptmgmt.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.aptmgmt.config.AptMgmtConfigTestBase;

public class BuildingDAOImplTest extends AptMgmtConfigTestBase {
	@Test
	@Rollback(true)
	public void happyTest(){
		Assert.assertTrue(true);
	}
}
