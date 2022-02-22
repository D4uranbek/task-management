package uz.boom.citizens.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.organization.OrganizationCreateDto;
import uz.boom.citizens.dto.organization.OrganizationDto;
import uz.boom.citizens.dto.organization.OrganizationDto.OrganizationDtoBuilder;
import uz.boom.citizens.dto.organization.OrganizationUpdateDto;
import uz.boom.citizens.entity.organization.Organization;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-22T11:25:09+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDto toDto(Organization e) {
        if ( e == null ) {
            return null;
        }

        OrganizationDtoBuilder organizationDto = OrganizationDto.childBuilder();

        organizationDto.id( e.getId() );
        organizationDto.name( e.getName() );
        organizationDto.logo( e.getLogo() );
        organizationDto.code( e.getCode() );
        organizationDto.location( e.getLocation() );
        organizationDto.email( e.getEmail() );
        organizationDto.owner( e.getOwner() );

        return organizationDto.build();
    }

    @Override
    public List<OrganizationDto> toDto(List<Organization> e) {
        if ( e == null ) {
            return null;
        }

        List<OrganizationDto> list = new ArrayList<OrganizationDto>( e.size() );
        for ( Organization organization : e ) {
            list.add( toDto( organization ) );
        }

        return list;
    }

    @Override
    public Organization fromCreateDto(OrganizationCreateDto organizationCreateDto) {
        if ( organizationCreateDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationCreateDto.getName() );
        organization.setEmail( organizationCreateDto.getEmail() );
        organization.setCode( organizationCreateDto.getCode() );

        return organization;
    }

    @Override
    public Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto) {
        if ( organizationUpdateDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationUpdateDto.getName() );
        organization.setEmail( organizationUpdateDto.getEmail() );
        organization.setCode( organizationUpdateDto.getCode() );

        return organization;
    }

    @Override
    public Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto, Organization organization) {
        if ( organizationUpdateDto == null ) {
            return null;
        }

        organization.setName( organizationUpdateDto.getName() );
        organization.setEmail( organizationUpdateDto.getEmail() );
        organization.setCode( organizationUpdateDto.getCode() );

        return organization;
    }
}
