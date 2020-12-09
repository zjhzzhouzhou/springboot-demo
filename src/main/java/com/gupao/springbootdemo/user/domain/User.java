package com.gupao.springbootdemo.user.domain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 类User.java的实现描述：用户测试表 entity
 * 
 * @author yupeng 2020-06-19 15:00:37
 */
@Getter
@Setter
public class User {

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
}
