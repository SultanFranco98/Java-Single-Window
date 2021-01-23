package university.singlewindow.mapper.subdivision;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.singlewindow.dto.subdivision.group.GroupResponse;
import university.singlewindow.entity.subdivision.Group;

@Component
public class GroupMapper {

    public GroupResponse toGroupResponse(@NonNull Group group) {
        return GroupResponse.builder()
                .id(group.getId())
                .title(group.getTitle())
                .specialtyId(group.getSpecialty().getId())
                .build();
    }
}
