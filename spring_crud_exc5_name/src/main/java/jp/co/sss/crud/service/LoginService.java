package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.bean.LoginResultBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;


@Service
public class LoginService {

	
	@Autowired
	private EmployeeRepository repository;

	
	public LoginResultBean execute(LoginForm loginForm) {

		LoginResultBean loginResultBean = null;
		Employee employee = repository.findByEmpIdAndEmpPass(loginForm.getEmpId(), loginForm.getEmpPass());

		if (employee != null) {
			EmployeeBean loginUser = BeanManager.copyEntityToBean(employee);
			loginResultBean = LoginResultBean.succeedLogin(loginUser);
		} else {
			loginResultBean = LoginResultBean.failLogin("社員ID、またはパスワードが間違っています。");
		}

		return loginResultBean;

	}

}