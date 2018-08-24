package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.exception.NotRunException;
import com.example.demo.service.impl.GeneratorNextImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceImplTest {

	@Autowired
	@Qualifier("A")
	private UnitService unitService;

	@Autowired
	@Qualifier("Next")
	private GeneratorNextImpl next;

	// @Test
	public void testTransaction1() {
		System.out.println("begin1");
		unitService.Transaction1();
		System.out.println("end1");
	}

	// @Test
	// public void testTransaction2() {
	// System.out.println("begin1");
	// unitService.Transaction2();
	// System.out.println("end1");
	// }

	// @Test
	// public void testTransaction3() {
	// System.out.println("begin1");
	// unitService.Transaction3();
	// System.out.println("end1");
	// }

	// @Test
	// public void testTransaction4() {
	// System.out.println("begin1");
	// unitService.Transaction4();
	// System.out.println("end1");
	// }

//	@Test
//	public void testTransaction5() {
//		System.out.println("begin1");
//		unitService.Transaction5();
//		System.out.println("end1");
//	}
//	
	
	@Test
	public void testTransaction6() {
		System.out.println("begin1");
		unitService.Transaction6();
		System.out.println("end1");
	}
	
	// @Test
	// public void testTransaction7() {
	// System.out.println("begin1");
	// try {
	// unitService.Transaction7();
	// } catch (NotRunException e) {
	// System.out.println("Exception ~");
	// }
	// System.out.println("end1");
	// }
	// @Test
	// public void testGetNextVal() {
	// next.getNextVal();
	// }

}
