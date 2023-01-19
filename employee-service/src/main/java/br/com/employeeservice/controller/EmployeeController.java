package br.com.employeeservice.controller;

import br.com.employeeservice.dto.APIResponseDto;
import br.com.employeeservice.dto.EmployeeDto;
import br.com.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(
                employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                employeeService.getEmployeeById(id),
                HttpStatus.OK
        );
    }
}
