package com.api.dao;


import java.util.List;

import com.api.entity.Employee;

public interface Dao{
	

		void saveEmployee(Employee Employee);

		Employee getEmployeeById(long id);

		List<Employee> getAllEmployees();

		int updateEmployee(int id,Employee Employee);

		int deleteEmployeeById(int id);

	}

