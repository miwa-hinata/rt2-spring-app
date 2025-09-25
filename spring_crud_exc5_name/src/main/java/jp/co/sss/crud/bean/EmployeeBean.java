package jp.co.sss.crud.bean;

import java.util.Date;

//従業員情報を管理するJavaBeanクラス。

public class EmployeeBean {

	private Integer empId;

	private String empPass;

	private String empName;

	private Integer gender;

	private String address;

	private Date birthday;

	private Integer authority;

	private Integer deptId;

	private String deptName;

	public EmployeeBean() {
	}

	//全てのフィールドを指定するコンストラクタ。
	public EmployeeBean(Integer empId, String empPass, String empName, Integer gender, String address, Date birthday,
			Integer authority, Integer deptId) {
		this.empId = empId;
		this.empPass = empPass;
		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.authority = authority;
		this.deptId = deptId;

		switch (deptId) {
		case 1:
			this.deptName = "営業部";
			break;
		case 2:
			this.deptName = "経理部";
			break;
		case 3:
			this.deptName = "総務部";

			break;

		default:
			break;
		}

	}

	
	public Integer getEmpId() {
		return empId;
	}
	
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;

	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;

		switch (deptId) {
		case 1:
			this.deptName = "営業部";
			break;
		case 2:
			this.deptName = "経理部";

			break;
		case 3:
			this.deptName = "総務部";

			break;

		default:
			break;
		}

	}

	public String getDeptName() {
		return deptName;
	}

	
	public void setDeptName(String deptName) {

		this.deptName = deptName;
	}

}