package uz.elmurodov.spring_boot.reposiroty;

import org.hibernate.annotations.NamedNativeQuery;
import org.mapstruct.MappingTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

}
