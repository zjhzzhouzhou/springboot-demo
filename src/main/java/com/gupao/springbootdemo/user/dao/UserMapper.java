package com.gupao.springbootdemo.user.dao;

import com.gupao.springbootdemo.user.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类UserMapper.java的实现描述：用户测试表 dao
 * 
 * @author yupeng 2020-06-19 15:00:37
 */
public interface UserMapper {

	/**
	 * 保存对象
	 * 
	 * @param user
	 */
	Integer insert(User user);
	
	/**
     * 查询
     * 
     * @param id
     * @return
     */
	User getUserById(@Param("id") Long id);
	
	/**
     * 更新
     * 
     * @param user
     * @return
     */
    Integer updateById(@Param("obj") User user);
	
	 /**
     * 根据条件求和
     * 
     * @param para
     * @return
     */
    Integer countByPara(@Param("para") String para);

     /**
     * 查询分页
     *
     * @param user
     * @param beginId
     * @param pageSize
     * @return
     */
     List<User> pageByPara(@Param("obj") User user, @Param("beginId") long beginId, @Param("pageSize") int pageSize);
	 
	 /**
     * 列表查询
     *
     * @param user
     * @return
     */
     List<User> listByPara(@Param("obj") User user);


}
