package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.po.Person;

/**
 * Created with IntelliJ IDEA.
 *
 * Description:
 *
 * @author haifengDai
 *
 *         Date: 2018-08-22 下午9:10
 */
@Mapper
public interface PersonMapper {

	@Select("SELECT * FROM T_TEST_TRANSACTION")
	List<Person> listAll();

	@Insert("insert into T_TEST_TRANSACTION(name, score,grade) values(#{name}, #{score},#{grade})")
	boolean insert(Person po);

	@Update("update T_TEST_TRANSACTION set name = #{name}, score = #{score} ,grade = #{grade} where id=#{id}")
	public int update(Person po);

	@Select("select * from T_TEST_TRANSACTION where id = #{id}")
	public Person getPoById(int id);
	

	@Select("select SEQ_USER_AUDIT_ID.nextval from dual ")
	public int getNextVal();

}
