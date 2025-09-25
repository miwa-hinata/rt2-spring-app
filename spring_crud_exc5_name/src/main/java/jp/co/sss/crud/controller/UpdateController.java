package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.service.SearchForEmployeesByEmpIdService;
import jp.co.sss.crud.service.UpdateEmployeeService;
import jp.co.sss.crud.util.BeanManager;

@Controller
public class UpdateController {

	@Autowired
	SearchForEmployeesByEmpIdService searchForEmployeesByEmpIdService;

	@Autowired
	UpdateEmployeeService updateEmployeeService;

	//社員情報の変更内容入力画面を出力
	@RequestMapping(path = "/update/input", method = RequestMethod.GET)
	public String inputUpdate(Integer empId, @ModelAttribute EmployeeForm employeeForm, Model model) {

		EmployeeBean employee = searchForEmployeesByEmpIdService.execute(empId);

		employeeForm = BeanManager.copyBeanToForm(employee);
		model.addAttribute("employeeForm", employee);

		return "update/update_input";
	}

	// 社員情報の変更確認画面を出力
	@RequestMapping(path = "/update/check", method = RequestMethod.POST)
	public String checkUpdate(@Valid @ModelAttribute EmployeeForm employeeForm,BindingResult result) {
		if(result.hasErrors()){
			return "update/update_input.html";
		}
		return "update/update_check";
	}

	// 変更内容入力画面に戻る
	@RequestMapping(path = "/update/back", method = RequestMethod.POST)
	public String backInputUpdate(@ModelAttribute EmployeeForm employeeForm) {
		return "update/update_input";
	}

	//社員情報の変更
	@RequestMapping(path = "/update/complete", method = RequestMethod.POST)
	public String completeUpdate(EmployeeForm employeeForm,HttpSession session) {

		updateEmployeeService.execute(employeeForm);
		EmployeeBean inputEmpbean = BeanManager.copyFormToBean(employeeForm);
		EmployeeBean loginEmpBean = ((EmployeeBean)session.getAttribute("loginUser"));
		if(inputEmpbean.getEmpId()== loginEmpBean.getEmpId()) {
			session.setAttribute("loginUser", inputEmpbean);
		}
		
		return "redirect:/update/complete";
	}

	// 完了画面の表示
	@RequestMapping(path = "/update/complete", method = RequestMethod.GET)
	public String completeUpdate() {
		return "update/update_complete";
	}

}
