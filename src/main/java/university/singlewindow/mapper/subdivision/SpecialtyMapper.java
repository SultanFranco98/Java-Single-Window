package university.singlewindow.mapper.subdivision;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.singlewindow.dto.subdivision.specialty.SpecialtyResponse;
import university.singlewindow.entity.subdivision.Specialty;

@Component
public class SpecialtyMapper {

    public SpecialtyResponse toSpecialtyResponse(@NonNull Specialty specialty) {
        return SpecialtyResponse.builder()
                .id(specialty.getId())
                .title(specialty.getTitle())
                .faculty(specialty.getFaculty())
                .build();
    }
}
