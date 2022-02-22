package uz.boom.spring_boot.services.organization;

import uz.boom.spring_boot.criteria.GenericCriteria;
import uz.boom.spring_boot.dto.organization.OrganizationCreateDto;
import uz.boom.spring_boot.dto.organization.OrganizationDto;
import uz.boom.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.boom.spring_boot.entity.organization.Organization;
import uz.boom.spring_boot.services.GenericCrudService;

public interface OrganizationService extends GenericCrudService<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {



}
