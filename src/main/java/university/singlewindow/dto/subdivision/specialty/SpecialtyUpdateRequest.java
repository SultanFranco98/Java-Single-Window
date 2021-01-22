package university.singlewindow.dto.subdivision.specialty;

import lombok.Getter;
import lombok.Setter;
import university.singlewindow.entity.subdivision.Faculty;

@Getter
@Setter
public class SpecialtyUpdateRequest {

    private Long id;
    private String title;
    private Faculty faculty;
}
