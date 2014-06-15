package com.doorcii.saas.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.doorcii.saas.daos.CommonDAO;
import com.doorcii.saas.domains.CategoryErrors;
import com.doorcii.saas.domains.Result;
import com.doorcii.saas.handler.DAOFunctionNameHandle;

public class CommonManager {
	
	public static final Logger logger = Logger.getLogger("CommonManager-");
	
	private DAOFunctionNameHandle functionNameHandle;
	
	private CommonDAO commonDAO;
	
	public Result<List<Map<String,String>>> invokeProcedureList(String procedureName,String [] params) {
		Result<List<Map<String,String>>> result = Result.getDefaultResult();
		if(!functionNameHandle.contains(procedureName)) {
			result.setSuccess(false);
			result.setErrorMsg(CategoryErrors.PROCEDURE_DOES_NOT_EXIST.getMsg());
			result.setErrorCode(CategoryErrors.PROCEDURE_DOES_NOT_EXIST.getCode());
			return result;
		}
		
		try {
			List<Map<String, String>> resultList = commonDAO.executeReturnList(procedureName, params);
			result.setSuccess(true);
			result.setValue(resultList);
			return result;
		} catch (SQLException e) {
			logger.error("executeReturnList error.",e);
			result.setSuccess(false);
			result.setErrorCode(CategoryErrors.EXCEPTIONS.getCode());
			result.setErrorMsg(CategoryErrors.EXCEPTIONS.getMsg());
			return result;
		}
		
	}

	public void setFunctionNameHandle(DAOFunctionNameHandle functionNameHandle) {
		this.functionNameHandle = functionNameHandle;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
}
