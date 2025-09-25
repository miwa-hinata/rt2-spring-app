package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.repository.EmployeeRepository;


@Service
public class DeleteEmployeeService {

	@Autowired
	EmployeeRepository repository;

	public void execute(Integer forDeleteEmpId) {

		repository.deleteById(forDeleteEmpId);

	}

}
