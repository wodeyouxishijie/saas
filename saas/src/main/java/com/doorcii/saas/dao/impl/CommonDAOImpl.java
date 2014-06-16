package com.doorcii.saas.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.doorcii.saas.daos.CommonDAO;

/**
 * ¶¯Ì¬½á¹ûÓ³Éä
 * @author Jacky
 * 2014-6-14
 */
public class CommonDAOImpl extends BaseDAO implements CommonDAO {

	public static final Logger logger = Logger.getLogger("DAO-LOG");
	
	private static final String CALL = "{CALL ";
	
	private static final String R_M_QUOTE = " }";
	
	private static final String L_QUOTE = "( ";
	
	private static final String QUES = " ? ";
	
	private static final String SEP = ",";
	
	private static final String CLOSE = ")}";
	
	private static final String SPLIT = "***********************************";
	
	@Override
	public List<Map<String, String>> executeReturnList(String procedureName,
			String[] param) throws SQLException {
		List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
		Connection connection = null;
		CallableStatement stmt = null;
		ResultSet resultSet = null;
		try {
			connection = this.getSqlMapClientTemplate().getDataSource().getConnection();
			String sql = getSql(procedureName,param);
			logger.info(SPLIT);
			logger.info("sql:"+sql+",param=["+getParamStr(param)+"]");
			stmt = connection.prepareCall(sql);
			initParameter(stmt,param);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Map<String,String> resultMap = new HashMap<String,String>();
				ResultSetMetaData meta = resultSet.getMetaData();
				for(int i = 1 ; i <= meta.getColumnCount() ; i++) {
					resultMap.put(meta.getColumnName(i), resultSet.getString(i));
				}
				resultList.add(resultMap);
			}
			logger.info("resultList:"+resultList);
			logger.info(SPLIT);
		} finally {
			if(null != resultSet) {
				resultSet.close();
			}
			if( null != stmt ) {
				stmt.close();
			}
			if( null != connection ) {
				connection.close();
			}
		}
		return resultList;
	}

	private String getParamStr(String [] param) {
		if(null != param) {
			StringBuilder sb = new StringBuilder();
			for(String p : param) {
				sb.append(p).append(SEP);
			}
			return sb.toString();
		}
		return null;
	}
	
	private void initParameter(CallableStatement stmt,String[] params) throws SQLException {
		if(null != params && params.length > 0) {
			for(int i=0 ; i < params.length ; i++) {
				stmt.setString(i+1, params[i]);
			}
		}
	}
	
	@Override
	public Map<String, String> executeReturnObject(String procedureName,
			String[] param) throws SQLException {
		Connection connection = null;
		CallableStatement stmt = null;
		ResultSet resultSet = null;
		try {
			connection = this.getSqlMapClientTemplate().getDataSource().getConnection();
			String sql = getSql(procedureName,param);
			System.out.println(sql);
			stmt = connection.prepareCall(sql);
			initParameter(stmt,param);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Map<String,String> resultMap = new HashMap<String,String>();
				ResultSetMetaData meta = resultSet.getMetaData();
				for(int i = 1 ; i <= meta.getColumnCount() ; i++) {
					resultMap.put(meta.getColumnName(i), resultSet.getString(i));
				}
				return resultMap;
			}
		} finally {
			if(null != resultSet) {
				resultSet.close();
			}
			if( null != stmt ) {
				stmt.close();
			}
			if( null != connection ) {
				connection.close();
			}
		}
		return new HashMap<String,String>(0);
	}
	
	private String getSql(String proc,String[] param) {
		StringBuilder sb = new StringBuilder(CALL);
		sb.append(proc);
		if(param == null || param.length == 0) {
			return sb.append(R_M_QUOTE).toString();
		}
		sb.append(L_QUOTE);
		for( int i=0 ; i < param.length ; i++ ) {
			sb.append(QUES);
			if(i < param.length - 1) {
				sb.append(SEP);
			}
		}
		return sb.append(CLOSE).toString();
	}

}
