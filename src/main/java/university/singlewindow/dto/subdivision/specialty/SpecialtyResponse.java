package university.singlewindow.dto.subdivision.specialty;

import lombok.Builder;
import lombok.Getter;
import university.singlewindow.entity.subdivision.Faculty;

@Getter
@Builder
public class SpecialtyResponse {

    private Long id;
    private String title;
    private Faculty faculty;
}
