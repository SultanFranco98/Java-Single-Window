package university.singlewindow.mapper.subdivision;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.singlewindow.dto.subdivision.faculty.FacultyResponse;
import university.singlewindow.entity.subdivision.Faculty;

@Component
public class FacultyMapper {

    public FacultyResponse toFacultyResponse(@NonNull Faculty faculty) {
        return FacultyResponse.builder()
                .id(faculty.getId())
                .title(faculty.getTitle())
                .build();
    }
}
