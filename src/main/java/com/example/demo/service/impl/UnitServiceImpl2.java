package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.po.Person;
import com.example.demo.service.UnitService;


@Service("B")
public class UnitServiceImpl2 implements UnitService{

	@Resource
	private PersonMapper mapper;
	
	@Override
	public void Transaction1() {
		
	}

	@Override
	public void Transaction2() {
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void Transaction3() {
		Person p2 = new Person();
		p2.setGrade(2);
		p2.setName("2");
		p2.setScore(2);
		mapper.insert(p2);
	}

	@Override
	public void Transaction4() {
		
	}
	/**
	 * 开启新的事务
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void Transaction5() {
		Person p3=new Person();
		p3.setGrade(7);
		p3.setName("7");
		p3.setScore(7);
		mapper.insert(p3);
	}

	@Override
	public void Transaction6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Transaction7() {
		// TODO Auto-generated method stub
		
	}

}
