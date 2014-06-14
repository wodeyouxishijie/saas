package com.doorcii.saas.daos;

import java.sql.SQLException;
import java.util.List;

import com.doorcii.saas.domains.CategoryDO;

/**
 * ��Ŀ�ӿ�
 * @author chenjie
 */
public interface CategoryDAO {
	
	/**
	 * �������ڲ�ѯ��ԤԼ����
	 * 
	 * @param date
	 *  date == null ��� ��ѯδ�������ԤԼ����
	 * @return
	 * @throws SQLException
	 */
	public List<CategoryDO> queryCategoryList(String date) throws SQLException ;
	
	
	
}
