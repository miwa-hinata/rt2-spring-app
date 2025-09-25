package jp.co.sss.crud.bean;

/**
 * 
 */
public class LoginResultBean {

	private boolean isLogin;
	
	private EmployeeBean loginUser;
	
	private String errorMsg;

	private LoginResultBean(EmployeeBean loginUser) {
		this.loginUser = loginUser;
		this.isLogin = true;
	}

	
	private LoginResultBean(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public static LoginResultBean succeedLogin(EmployeeBean loginUser) {
		return new LoginResultBean(loginUser);
	}

	
	public static LoginResultBean failLogin(String errorMsg) {
		return new LoginResultBean(errorMsg);
	}

	
	public boolean isLogin() {
		return isLogin;
	}

	public EmployeeBean getLoginUser() {
		return loginUser;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
