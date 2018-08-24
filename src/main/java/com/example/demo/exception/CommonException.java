package com.example.demo.exception;

/**
 * 运行时异常 
 * @author Administrator
 *
 */
public class CommonException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	
	public CommonException (){
		super();
	}
	public CommonException(String message){
		super(message);
	}
}
