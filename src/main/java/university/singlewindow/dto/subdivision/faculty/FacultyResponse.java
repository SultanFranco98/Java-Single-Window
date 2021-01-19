package university.singlewindow.dto.subdivision.faculty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FacultyResponse {

    private Long id;
    private String title;
}
