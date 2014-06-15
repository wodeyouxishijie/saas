package com.doorcii.saas.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 通用DAO
 * @author Jacky
 * 2014-6-14
 */
public interface CommonDAO {
	
	/**
	 * 执行并返回LIST
	 * @param procedureName
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,String>> executeReturnList(String procedureName, String[] param) throws SQLException ;
	
	/**
	 * 执行并返回OBJECT
	 * @param procedureName
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public Map<String,String> executeReturnObject(String procedureName, String[] param) throws SQLException;
	
}
