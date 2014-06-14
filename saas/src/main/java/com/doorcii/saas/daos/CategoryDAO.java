package com.doorcii.saas.daos;

import java.sql.SQLException;
import java.util.List;

import com.doorcii.saas.domains.CategoryDO;

/**
 * 类目接口
 * @author chenjie
 */
public interface CategoryDAO {
	
	/**
	 * 根据日期查询可预约科室
	 * 
	 * @param date
	 *  date == null 情况 查询未来七天可预约科室
	 * @return
	 * @throws SQLException
	 */
	public List<CategoryDO> queryCategoryList(String date) throws SQLException ;
	
	
	
}
