package com.doorcii.saas.domains;

/**
 * ���������
 * @author Jacky
 * 2014-5-9
 */
public enum CategoryErrors {
	
	/**
	 * ϵͳ�쳣
	 */
	EXCEPTIONS("ϵͳ�쳣,���Ժ�����",10001),
	/**
	 * ������Ч
	 */
	PARAM_INVALID("������Ч",10002),
	
	/**
	 * ���Ҳ�����
	 */
	CATEGORY_NOT_EXIST("���Ҳ�����",10003),
	
	/**
	 * �߼�����
	 */
	LOGICAL_ERROR("�߼�����",10004),
	
	/**
	 * ԤԼ��¼������
	 */
	RECORD_NOT_EXIST("ԤԼ��¼������",10005),
	
	/**
	 * ԤԼ�Ѿ�����
	 */
	RESERVE_IS_FULL("ԤԼ�Ѿ�����",10006),
	
	/**
	 * ԤԼ��¼����ʧ��
	 */
	RECORD_INSERT_ERROR("ԤԼ��¼����ʧ��",10007),
	
	/**
	 * �Ѿ�ԤԼ����
	 */
	HAS_RESERVED("�Ѿ�ԤԼ����",10008),
	
	/**
	 * ԤԼ��¼����ʧ��
	 */
	RECORD_UPDATE_ERROR("ԤԼ��¼����ʧ��",10009),
	
	/**
	 * �ֻ��ű���������
	 */
	PHONE_NOT_A_NUM("����д��Ч���ֻ�����",10010),
	
	/**
	 * �ֻ��Ų���Ϊ��
	 */
	PHONE_NOT_BLANK("�ֻ��Ų���Ϊ��",10011),
	
	/**
	 * ���벻��Ϊ��
	 */
	PASS_NOT_BLANK("����д���Ȳ�����6~16λ������",10012),
	
	/**
	 * ȷ�����벻��Ϊ��
	 */
	CON_PASS_NOT_BLANK("ȷ�����벻��Ϊ��",10013),
	
	/**
	 * ֤���Ų���Ϊ��
	 */
	CARD_NO_NOT_BLANK("����д��Ч��֤������",10014),
	
	/**
	 * ֤�����Ͳ���Ϊ��
	 */
	CARD_TYPE_NOT_BLANK("֤�����Ͳ���Ϊ��",10015),
	
	/**
	 * ��������Ϊ��
	 */
	REAL_NAME_NOT_BLANK("����д��Ч����ʵ����",10016),
	
	/**
	 * ֤�����Ͳ�������
	 */
	CARD_TYPE_NOT_NUM("֤�����Ͳ�������",10017),
	
	/**
	 * �������벻��
	 */
	PWD1_NOT_EQUAL_PWD2("�������벻��",10018),
	
	
	/**
	 * �û�������
	 */
	USER_NOT_EXIST("�û�������",10019),
	
	/**
	 * �������
	 */
	PASSWORD_NOT_RIGHT("�������",10020),
	
	/**
	 * �û�δ��½
	 */
	USER_NOT_LOGIN("�û�δ��½",10021),
	
	/**
	 * ��ѯʧ��
	 */
	QUERY_FAILED("��ѯʧ��",10022),
	
	/**
	 * û���㹻��Դ
	 */
	NO_ENOUGH_NO("û���㹻��Դ",10023),
	
	/**
	 * ԤԼʧ��
	 */
	RESERVE_FAILED("ԤԼʧ��",10024),
	
	/**
	 * webservice ���Ϊnull
	 */
	WEB_SERVCIE_RESULT_NULL("�ӿڲ�ѯ����",10025),
	
	/**
	 * ���ƿ��Ų���Ϊ��
	 */
	HOSPITAL_CARD_NOT_BLANK("���ƿ��Ų���Ϊ��",10026),
	
	/**
	 * token��Ч
	 */
	TOKEN_INVALID("TOKEN ��Ч",10027),
	
	/**
	 * token����
	 */
	TOKEN_EXPIRED("TOKEN ����",10028),
	
	NEED_REG("��ע�������Ϣ",10029),
	
	HOS_CARD_BLANK("���ƿ���Ϣ����Ϊ��",10030),
	
	USER_EXISTED("���û��Ѿ�����",10031),
	
	VALIDATE_FAILED("����У��ʧ��",10032),
	
	HAS_BINDED_CARD("�����ƿ��Ѿ������󶨹���",10033),
	
	RECORD_DOES_NOT_EXIST("�ü�¼�Ѿ�������",10034),
	
	SMS_SEND_FAILED("���ŷ���ʧ��",10035),
	
	SMS_SEND_FREQUENCY("���ŷ���Ƶ�ʹ���",10036),
	
	NEED_CHECK_CODE("��Ҫ��֤��",10037),
	
	CHECK_CODE_EXPIRED("��֤�����",10038),
	
	CHECK_CODE_NOT_RIGHT("������֤�벻��ȷ",10039),
	
	BINDING_CARD_EXCEED("�����ƿ����ܳ���5��",10040),
	
	UPDATE_PWD_FAILED("�޸�����ʧ��",10041),
	
	PROCEDURE_DOES_NOT_EXIST("�洢���̲�����",10042);
	
	private String msg;
	
	private int code;
	
	private CategoryErrors (String msg,int code) {
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
