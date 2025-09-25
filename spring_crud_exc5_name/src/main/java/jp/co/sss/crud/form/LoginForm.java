package jp.co.sss.crud.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginForm {

	@Min(value = 1)
    @Max(value = 99999)
    @NotNull
    private Integer empId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]{0,16}$")
    private String empPass;
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
}
