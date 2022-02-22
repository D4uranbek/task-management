package uz.elmurodov.spring_boot.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.file.ResourceDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.mapper.OrganizationMapper;
import uz.elmurodov.spring_boot.reposiroty.OrganizationRepository;
import uz.elmurodov.spring_boot.services.AbstractService;
import uz.elmurodov.spring_boot.services.file.FileStorageService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.organization.OrganizationValidator;

import java.io.IOException;
import java.util.List;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    private final FileStorageService fileStorageService;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository, OrganizationMapper mapper, OrganizationValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getLogo());
        Organization organization = mapper.fromCreateDto(createDto);
        organization.setLogo("/uploads/" + resourceDto.getPath());
        repository.save(organization);
        return organization.getId();
    }

//    public Long create(OrganizationCreateDto createDto, MultipartFile logo) throws IOException {
//        ResourceDto resourceDto = fileStorageService.store(logo);
//        Organization organization = mapper.fromCreateDto(createDto);
//        organization.setLogo(resourceDto.getPath());
//        repository.save(organization);
//        return organization.getId();
//    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto dto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(dto.getLogo());

        Organization organization = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        mapper.fromUpdateDto(dto, organization);
        organization.setLogo("/uploads/" + resourceDto.getPath());
        repository.save(organization);
        return null;
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(organization);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
