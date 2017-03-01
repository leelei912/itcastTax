package cn.itcastTax.nsfw.role.dao.impl;

import org.hibernate.Query;

import cn.itcastTax.core.dao.impl.BaseDaoImpl;
import cn.itcastTax.nsfw.role.dao.RoleDao;
import cn.itcastTax.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
