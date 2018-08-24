package com.example.demo.service;

import com.example.demo.exception.NotRunException;

/**
 * Created with IntelliJ IDEA.
 *
 * Description:
 *
 * @author haifengDai
 *
 *         Date: 2018-08-22 下午9:19
 */
public interface UnitService {
	 void Transaction1();
	 void Transaction2();
	 void Transaction3();
	 void Transaction4();
	 
	 void Transaction5();
	 void Transaction6();
	 void Transaction7() throws NotRunException;
}
