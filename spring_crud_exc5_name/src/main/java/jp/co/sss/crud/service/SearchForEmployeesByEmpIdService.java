package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;


@Service
public class SearchForEmployeesByEmpIdService {

	
	@Autowired
	private EmployeeRepository repository;

	
	public EmployeeBean execute(Integer empId) {

		Employee employee = repository.getReferenceById(empId);
		EmployeeBean employeeBean = BeanManager.copyEntityToBean(employee);

		return employeeBean;
	}

}