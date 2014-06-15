package com.doorcii.saas.domains;

/**
 * 错误码分类
 * @author Jacky
 * 2014-5-9
 */
public enum CategoryErrors {
	
	/**
	 * 系统异常
	 */
	EXCEPTIONS("系统异常,请稍后再试",10001),
	/**
	 * 参数无效
	 */
	PARAM_INVALID("参数无效",10002),
	
	/**
	 * 科室不存在
	 */
	CATEGORY_NOT_EXIST("科室不存在",10003),
	
	/**
	 * 逻辑错误
	 */
	LOGICAL_ERROR("逻辑错误",10004),
	
	/**
	 * 预约记录不存在
	 */
	RECORD_NOT_EXIST("预约记录不存在",10005),
	
	/**
	 * 预约已经满了
	 */
	RESERVE_IS_FULL("预约已经满了",10006),
	
	/**
	 * 预约记录插入失败
	 */
	RECORD_INSERT_ERROR("预约记录插入失败",10007),
	
	/**
	 * 已经预约过了
	 */
	HAS_RESERVED("已经预约过了",10008),
	
	/**
	 * 预约记录更新失败
	 */
	RECORD_UPDATE_ERROR("预约记录更新失败",10009),
	
	/**
	 * 手机号必须是数字
	 */
	PHONE_NOT_A_NUM("请填写有效的手机号码",10010),
	
	/**
	 * 手机号不能为空
	 */
	PHONE_NOT_BLANK("手机号不能为空",10011),
	
	/**
	 * 密码不能为空
	 */
	PASS_NOT_BLANK("请填写长度不超过6~16位的密码",10012),
	
	/**
	 * 确认密码不能为空
	 */
	CON_PASS_NOT_BLANK("确认密码不能为空",10013),
	
	/**
	 * 证件号不能为空
	 */
	CARD_NO_NOT_BLANK("请填写有效的证件号码",10014),
	
	/**
	 * 证件类型不能为空
	 */
	CARD_TYPE_NOT_BLANK("证件类型不能为空",10015),
	
	/**
	 * 姓名不能为空
	 */
	REAL_NAME_NOT_BLANK("请填写有效的真实姓名",10016),
	
	/**
	 * 证件类型不是数字
	 */
	CARD_TYPE_NOT_NUM("证件类型不是数字",10017),
	
	/**
	 * 两次密码不符
	 */
	PWD1_NOT_EQUAL_PWD2("两次密码不符",10018),
	
	
	/**
	 * 用户不存在
	 */
	USER_NOT_EXIST("用户不存在",10019),
	
	/**
	 * 密码错误
	 */
	PASSWORD_NOT_RIGHT("密码错误",10020),
	
	/**
	 * 用户未登陆
	 */
	USER_NOT_LOGIN("用户未登陆",10021),
	
	/**
	 * 查询失败
	 */
	QUERY_FAILED("查询失败",10022),
	
	/**
	 * 没有足够号源
	 */
	NO_ENOUGH_NO("没有足够号源",10023),
	
	/**
	 * 预约失败
	 */
	RESERVE_FAILED("预约失败",10024),
	
	/**
	 * webservice 结果为null
	 */
	WEB_SERVCIE_RESULT_NULL("接口查询错误",10025),
	
	/**
	 * 诊疗卡号不能为空
	 */
	HOSPITAL_CARD_NOT_BLANK("诊疗卡号不能为空",10026),
	
	/**
	 * token无效
	 */
	TOKEN_INVALID("TOKEN 无效",10027),
	
	/**
	 * token过期
	 */
	TOKEN_EXPIRED("TOKEN 过期",10028),
	
	NEED_REG("请注册个人信息",10029),
	
	HOS_CARD_BLANK("诊疗卡信息不能为空",10030),
	
	USER_EXISTED("该用户已经存在",10031),
	
	VALIDATE_FAILED("参数校验失败",10032),
	
	HAS_BINDED_CARD("该诊疗卡已经被您绑定过了",10033),
	
	RECORD_DOES_NOT_EXIST("该记录已经不存在",10034),
	
	SMS_SEND_FAILED("短信发送失败",10035),
	
	SMS_SEND_FREQUENCY("短信发送频率过高",10036),
	
	NEED_CHECK_CODE("需要验证码",10037),
	
	CHECK_CODE_EXPIRED("验证码过期",10038),
	
	CHECK_CODE_NOT_RIGHT("输入验证码不正确",10039),
	
	BINDING_CARD_EXCEED("绑定诊疗卡不能超过5张",10040),
	
	UPDATE_PWD_FAILED("修改密码失败",10041),
	
	PROCEDURE_DOES_NOT_EXIST("存储过程不存在",10042);
	
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
