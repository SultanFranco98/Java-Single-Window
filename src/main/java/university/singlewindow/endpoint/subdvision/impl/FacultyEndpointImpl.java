package university.singlewindow.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.dto.subdivision.faculty.FacultyResponse;
import university.singlewindow.dto.subdivision.faculty.FacultyUpdateRequest;
import university.singlewindow.endpoint.subdvision.FacultyEndpoint;
import university.singlewindow.entity.subdivision.Faculty;
import university.singlewindow.mapper.subdivision.FacultyMapper;
import university.singlewindow.services.subdivision.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyEndpointImpl implements FacultyEndpoint {

    private final FacultyService facultyService;
    private final FacultyMapper facultyMapper;

    public FacultyEndpointImpl(FacultyService facultyService, FacultyMapper facultyMapper) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
    }

    @Override
    @Transactional
    public FacultyResponse add(@NonNull FacultyCreateRequest request) {
        return facultyMapper.toFacultyResponse(facultyService.create(request));
    }

    @Override
    @Transactional
    public FacultyResponse update(@NonNull FacultyUpdateRequest request) {
        return facultyMapper.toFacultyResponse(facultyService.update(request));
    }

    @Override
    @Transactional(readOnly = true)
    public FacultyResponse getById(@NonNull Long id) {
        return facultyMapper.toFacultyResponse(facultyService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacultyResponse> getAll() {
        return facultyService.list()
                .stream()
                .map(facultyMapper::toFacultyResponse)
                .collect(Collectors.toList());
    }
}
