package com.example.demo.po;


/**
 * Created with IntelliJ IDEA.
 *
 * Description:
 *
 * @author haifengDai
 *
 * 		Date: 2018-08-22 下午9:11
 */
public class Person {
	
	private Integer id;
	private String name;
	private Integer score;
	private Integer grade;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "TestPo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				", grade=" + grade +
				'}';
	}
}
