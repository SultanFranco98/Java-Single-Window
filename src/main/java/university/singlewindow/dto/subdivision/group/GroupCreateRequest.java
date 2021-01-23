package university.singlewindow.dto.subdivision.group;

import lombok.Getter;
import lombok.Setter;
import university.singlewindow.entity.subdivision.Specialty;

@Getter
@Setter
public class GroupCreateRequest {

    private String title;
    private Specialty specialty;
}
