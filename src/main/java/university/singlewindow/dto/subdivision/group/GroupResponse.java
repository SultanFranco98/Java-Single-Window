package university.singlewindow.dto.subdivision.group;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupResponse {

    private Long id;
    private String title;
    private Long specialtyId;
}
