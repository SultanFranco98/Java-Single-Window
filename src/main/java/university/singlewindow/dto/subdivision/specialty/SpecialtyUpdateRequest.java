package university.singlewindow.dto.subdivision.specialty;

import lombok.Getter;
import university.singlewindow.entity.subdivision.Faculty;

@Getter
public class SpecialtyUpdateRequest {

    private Long id;
    private String title;
    private Faculty faculty;
}
