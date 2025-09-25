package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.service.RegisterEmployeeService;
import jp.co.sss.crud.util.Constant;

@Controller
public class RegistrationController {

	@Autowired
	private RegisterEmployeeService service;

	//社員情報の登録内容入力画面を出力
	@RequestMapping(path = "/regist/input", method = RequestMethod.GET)
	public String inputRegist(@ModelAttribute EmployeeForm employeeForm) {
		employeeForm.setGender(Constant.DEFAULT_GENDER);
		employeeForm.setAuthority(Constant.DEFAULT_AUTHORITY);
		employeeForm.setDeptId(Constant.DEFAULT_DEPT_ID);

		return "regist/regist_input";
	}

	//社員情報の登録確認画面を出力
	@RequestMapping(path = "/regist/check", method = RequestMethod.POST)
	public String checkRegist(@Valid @ModelAttribute EmployeeForm employeeForm,BindingResult result, Model model) {
		if(result.hasErrors()){
			return "regist/regist_input";
		}
		return "regist/regist_check.html";
	}
	
	

	//変更内容入力画面に戻る
	@RequestMapping(path = "/regist/back", method = RequestMethod.POST)
	public String backInputRegist(@ModelAttribute EmployeeForm employeeForm) {
		return "regist/regist_input";
	}

     //社員情報の登録完了画面を出力
	@RequestMapping(path = "/regist/complete", method = RequestMethod.POST)
	public String completeRegist(EmployeeForm employeeForm) {

		service.execute(employeeForm);

		return "redirect:/regist/complete";
	}


	 //完了画面表示
	
	@RequestMapping(path = "/regist/complete", method = RequestMethod.GET)
	public String completeRegist() {

		return "regist/regist_complete";
	}

}
