package university.singlewindow.services.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.group.GroupCreateRequest;
import university.singlewindow.dto.subdivision.group.GroupUpdateRequest;
import university.singlewindow.entity.subdivision.Group;
import university.singlewindow.exceptions.ResourceNotFoundException;
import university.singlewindow.repositories.subdivision.GroupRepository;
import university.singlewindow.services.subdivision.GroupService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    @Transactional
    public Group create(@NonNull GroupCreateRequest request) {
        Group group = new Group();
        group.setTitle(request.getTitle());
        group.setSpecialty(request.getSpecialty());
        group.setCreateAt(LocalDateTime.now());
        return groupRepository.save(group);
    }

    @Override
    @Transactional
    public Group put(@NonNull Long id, @NonNull GroupUpdateRequest request) {
        Group group = retrieve(id);
        group.setTitle(request.getTitle());
        group.setSpecialty(request.getSpecialty());
        group.setUpdateAt(LocalDateTime.now());
        return groupRepository.save(group);
    }

    @Override
    public String destroy(Long id) {
        Group group = retrieve(id);
        groupRepository.deleteById(group.getId());
        return "Group with id " + id + " removed";
    }

    @Override
    @Transactional(readOnly = true)
    public Group retrieve(@NonNull Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Group with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> list() {
        return groupRepository.findAll();
    }
}
