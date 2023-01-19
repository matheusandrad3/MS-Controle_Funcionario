package br.com.employeeservice.service;

import br.com.employeeservice.dto.APIResponseDto;
import br.com.employeeservice.dto.EmployeeDto;


public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
