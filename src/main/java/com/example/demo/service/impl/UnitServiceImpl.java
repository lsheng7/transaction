package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.CommonException;
import com.example.demo.exception.NotRunException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.po.Person;
import com.example.demo.service.UnitService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 *
 * Description:
 *
 * @author haifengDai
 *
 *         Date: 2018-08-22 下午9:19
 */
@Service("A")
@Slf4j
public class UnitServiceImpl implements UnitService {

	@Autowired
	@Qualifier("B")
	private UnitService serviceB;

	@Resource
	private PersonMapper mapper;

	@Transactional
	public void Transaction1() {
		Person p1 = new Person();
		p1.setGrade(1);
		p1.setName("1");
		p1.setScore(1);
		mapper.insert(p1);
		Person p2 = new Person();
		p2.setGrade(2);
		p2.setName("2");
		p2.setScore(2);
		mapper.insert(p2);
		int i = 9 / 0;// 会不会回滚? 會回滾
	}

	@Transactional
	public void Transaction2() {
		Person p1 = new Person();
		p1.setGrade(1);
		p1.setName("1");
		p1.setScore(1);
		mapper.insert(p1);
		insert2();
		int i = 9 / 0;// 会不会回滚? //會回滾
	}

	private void insert2() {// public void insert2()//會回滾
		Person p2 = new Person();
		p2.setGrade(2);
		p2.setName("2");
		p2.setScore(2);
		mapper.insert(p2);
	}

	@Override
	@Transactional
	public void Transaction3() {
		Person p1 = new Person();
		p1.setGrade(1);
		p1.setName("1");
		p1.setScore(1);
		mapper.insert(p1);
		serviceB.Transaction3();// 不会回滚
		int i = 9 / 0;// 会不会回滚?
	}

	/**
	 * seconds 设置事务的有效时间 超过这个时间事务就会失效 只是针对与最新的事务生效！
	 */
	@Override
	@Transactional(timeout = 2)
	public void Transaction4() {

		Person p1 = new Person();
		p1.setGrade(1);
		p1.setName("1");
		p1.setScore(1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.debug("timeout 5 s");
		}
		mapper.insert(p1);
	}

	@Override
	@Transactional(readOnly = true)
	public void Transaction5() {
		mapper.listAll().forEach(System.out::println);
		System.out.println("------------------------");
		serviceB.Transaction5();
		mapper.listAll().forEach(System.out::println);
	}

	@Override
	@Transactional
	// (noRollbackForClassName = "CommonException")
	public void Transaction6() {

		Person p = new Person();
		p.setName("9");
		p.setScore(9);
		p.setGrade(9);
		mapper.insert(p);
		throw new CommonException("Throw CommonException!~");
	}

	// 3.1 默认情况下，如果在事务中抛出了未检查异常（继承自 RuntimeException 的异常）或者 Error，
	// 则 Spring 将回滚事务；除此之外，Spring 不会回滚事务。
	// 你如果想要在特定的异常回滚可以考虑rollbackFor()等属性
	@Override
	@Transactional
	public void Transaction7() throws NotRunException {

		Person p = new Person();
		p.setGrade(10);
		p.setName("10");
		p.setScore(10);
		mapper.insert(p);
		throw new NotRunException("Throw NotRuntimeException!~");
	}
}
