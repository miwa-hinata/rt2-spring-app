package jp.co.sss.crud.form;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeForm {
	
	private Integer empId;

	
	@Pattern(regexp = "^[a-zA-Z0-9]{0,16}$",message="{Pattern.EmployeeForm.password}")
	@NotBlank
	private String empPass;

	@NotBlank
	@Size(max = 30)
	private String empName;

	private Integer gender;

	@NotBlank
	@Size(max = 60)
	private String address;

	@NotNull
	@Past(message="{Past.EmployeeForm.birthday}")
	private Date birthday;

	private Integer authority;

	private Integer deptId;

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
	}
}
