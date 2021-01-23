package university.singlewindow.services.subdivision;

import university.singlewindow.dto.subdivision.group.GroupCreateRequest;
import university.singlewindow.dto.subdivision.group.GroupUpdateRequest;
import university.singlewindow.entity.subdivision.Group;

import java.util.List;

public interface GroupService {
    Group create(GroupCreateRequest request);
    Group put(Long id, GroupUpdateRequest request);
    String destroy(Long id);
    Group retrieve(Long id);
    List<Group> list();
}
