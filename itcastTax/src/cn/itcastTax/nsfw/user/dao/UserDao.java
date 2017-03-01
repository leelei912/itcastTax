package cn.itcastTax.nsfw.user.dao;

import java.util.List;

import cn.itcastTax.core.dao.BaseDao;
import cn.itcastTax.nsfw.user.entity.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 根据帐号和用户id查询用户
	 * @param id 用户ID
	 * @param account 用户帐号
	 * @return 用户列表
	 */
	public List<User> findUserByAccountAndId(String id, String account);

}
