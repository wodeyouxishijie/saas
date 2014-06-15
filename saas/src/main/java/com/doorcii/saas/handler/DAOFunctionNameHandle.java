package com.doorcii.saas.handler;

import java.util.ArrayList;
import java.util.List;

public class DAOFunctionNameHandle {
	
	private List<String> procedureList = new ArrayList<String>(0);

	public boolean contains(String procedureFunction) {
		return procedureList.contains(procedureFunction);
	}
	
	public void setProcedureList(List<String> procedureList) {
		this.procedureList = procedureList;
	}
}
