package com.doorcii.saas.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doorcii.saas.daos.CategoryDAO;
import com.doorcii.saas.domains.CategoryDO;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryDO> queryCategoryList(String date) throws SQLException {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("date", date);
		return this.getSqlMapClientTemplate().queryForList("saas.queryCanReserveCategory", param);
	}
	
}
