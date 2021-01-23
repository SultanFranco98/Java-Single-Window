package university.singlewindow.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.group.GroupCreateRequest;
import university.singlewindow.dto.subdivision.group.GroupResponse;
import university.singlewindow.dto.subdivision.group.GroupUpdateRequest;
import university.singlewindow.endpoint.subdvision.GroupEndpoint;
import university.singlewindow.mapper.subdivision.GroupMapper;
import university.singlewindow.services.subdivision.GroupService;
import university.singlewindow.services.subdivision.SpecialtyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupEndpointImpl implements GroupEndpoint {

    private final GroupService groupService;
    private final SpecialtyService specialtyService;
    private final GroupMapper groupMapper;

    public GroupEndpointImpl(GroupService groupService, SpecialtyService specialtyService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.specialtyService = specialtyService;
        this.groupMapper = groupMapper;
    }

    @Override
    @Transactional
    public GroupResponse add(@NonNull GroupCreateRequest request) {
        request.setSpecialty(specialtyService.retrieve(request.getSpecialty().getId()));
        return groupMapper.toGroupResponse(groupService.create(request));
    }

    @Override
    @Transactional
    public GroupResponse update(@NonNull Long id, @NonNull GroupUpdateRequest request) {
        request.setSpecialty(specialtyService.retrieve(request.getSpecialty().getId()));
        return groupMapper.toGroupResponse(groupService.put(id, request));
    }

    @Override
    @Transactional
    public String delete(@NonNull Long id) {
        return groupService.destroy(id);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupResponse getById(@NonNull Long id) {
        return groupMapper.toGroupResponse(groupService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupResponse> getAll() {
        return groupService.list()
                .stream()
                .map(groupMapper::toGroupResponse)
                .collect(Collectors.toList());
    }
}
