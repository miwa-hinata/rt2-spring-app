package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;


@Service
public class UpdateEmployeeService {

	
	@Autowired
	private EmployeeRepository repository;

	
	public void execute(EmployeeForm employeeForm) {

		Employee employee = BeanManager.copyFormToEntity(employeeForm);

		repository.save(employee);

	}

}