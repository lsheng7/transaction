package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PersonMapper;

@Service("NextVal")
public class GeneratorNextImpl2 {

	@Resource
	private PersonMapper mapper;

	public int getNextVal() {
		return mapper.getNextVal();
	}

}
