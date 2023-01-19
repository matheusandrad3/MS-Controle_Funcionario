package br.com.departmentservice.service.impl;

import br.com.departmentservice.dto.DepartmentDto;
import br.com.departmentservice.entity.Department;
import br.com.departmentservice.repository.DepartmentRepository;
import br.com.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private ModelMapper modelMapper;
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);

    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        return  modelMapper.map(department, DepartmentDto.class);
    }
}
