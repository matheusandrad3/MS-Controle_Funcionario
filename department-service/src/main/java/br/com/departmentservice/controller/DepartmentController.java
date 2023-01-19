package br.com.departmentservice.controller;

import br.com.departmentservice.dto.DepartmentDto;
import br.com.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
   private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> findByDepartmentCode(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
