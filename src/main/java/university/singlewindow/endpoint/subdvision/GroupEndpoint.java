package university.singlewindow.endpoint.subdvision;

import university.singlewindow.dto.subdivision.group.GroupCreateRequest;
import university.singlewindow.dto.subdivision.group.GroupResponse;
import university.singlewindow.dto.subdivision.group.GroupUpdateRequest;

import java.util.List;

public interface GroupEndpoint {
    GroupResponse add(GroupCreateRequest request);
    GroupResponse update(Long id, GroupUpdateRequest request);
    String delete(Long id);
    GroupResponse getById(Long id);
    List<GroupResponse> getAll();
}
