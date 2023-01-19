package br.com.organizationservice.service.impl;

import br.com.organizationservice.dto.OrganizationDto;
import br.com.organizationservice.entity.Organization;
import br.com.organizationservice.repository.OrganizationRepository;
import br.com.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto, Organization.class);
        Organization saveOrganization = organizationRepository.save(organization);


        return modelMapper.map(saveOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return modelMapper.map(organization, OrganizationDto.class);
    }
}
