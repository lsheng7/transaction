package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("Next")
public class GeneratorNextImpl {

	@Autowired
	@Qualifier("NextVal")
	private GeneratorNextImpl2 nextValService;

	
	@Transactional
	public void getNextVal() {
		int val = methodA();
		System.out.println(val);
	}

	private int methodA() {

		return methodB();
	}

	private int methodB() {
		return nextValService.getNextVal();
	}

}
