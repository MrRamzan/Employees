package kg.megacom.EmployeeApp.Mappers;

import kg.megacom.EmployeeApp.Models.Experience;
import kg.megacom.EmployeeApp.Models.dto.ExperienceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExperienceMapper {

    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    ExperienceDto toDto(Experience experience);

    Experience toExperience(ExperienceDto experienceDto);

    List<ExperienceDto> toExperienceDtoList(List<Experience> experienceList);

    List<Experience> toExperienceList(List<ExperienceDto> experienceDtoList);
}
