package university.singlewindow.dto.subdivision.specialty;

import lombok.Getter;
import university.singlewindow.entity.subdivision.Faculty;

@Getter
public class SpecialtyCreateRequest {

    private String title;
    private Faculty faculty;
}
