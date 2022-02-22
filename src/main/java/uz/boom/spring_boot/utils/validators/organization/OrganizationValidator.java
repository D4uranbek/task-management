package uz.boom.spring_boot.utils.validators.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.spring_boot.dto.organization.OrganizationCreateDto;
import uz.boom.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.boom.spring_boot.exceptions.ValidationException;
import uz.boom.spring_boot.utils.BaseUtils;

@Component
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto, Long> {


    @Autowired
    protected OrganizationValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrganizationCreateDto organizationCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto cd) throws ValidationException {

    }
}