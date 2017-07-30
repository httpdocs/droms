package com.droms.test;

import org.junit.Test;

import com.droms.service.impl.DromitoryServiceImpl;

public class DromitoryTest {

	@Test
	public void test1(){
		
		System.out.println(new DromitoryServiceImpl().findDromitoryByPower(0));
		
	}
}
