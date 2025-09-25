package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;


@Service
public class SearchForEmployeesByDepartmentService {

	
	@Autowired
	EmployeeRepository repository;

	
	public List<EmployeeBean> execute(Integer deptId) {

		Department department = new Department();
		department.setDeptId(deptId);

		List<Employee> empList = repository.findByDepartmentOrderByEmpId(department);
		List<EmployeeBean> returnEmployeeBeans = BeanManager.copyEntityListToBeanList(empList);

		return returnEmployeeBeans;

	}

}
