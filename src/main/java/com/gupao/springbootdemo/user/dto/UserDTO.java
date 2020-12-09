package com.gupao.springbootdemo.user.dto;
import com.gupao.springbootdemo.user.domain.User;
import com.gupao.springbootdemo.util.BeanUtils;
import lombok.Data;

import java.util.Date;

/**
 * 类UserDTO.java的实现描述：用户测试表 DTO
 * 
 * @author yupeng 2020-06-19 15:00:37
 */
@Data
public class UserDTO  {

    
	/** id */
	private Long id;
	/** name */
	private String name;
	/** age */
	private Integer age;
	/** gmtCreate */
	private Date gmtCreate;
	/** gmtModified */
	private Date gmtModified;

	public static void main(String[] args) {
		User user = new User();
		user.setId(1L);
		user.setAge(10);
		user.setName("james");
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());

		UserDTO userDTO = BeanUtils.copy(user, UserDTO.class);
		System.out.println(userDTO);
	}
}
