package university.singlewindow.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.specialty.SpecialtyCreateRequest;
import university.singlewindow.dto.subdivision.specialty.SpecialtyResponse;
import university.singlewindow.dto.subdivision.specialty.SpecialtyUpdateRequest;
import university.singlewindow.endpoint.subdvision.SpecialtyEndpoint;
import university.singlewindow.mapper.subdivision.SpecialtyMapper;
import university.singlewindow.services.subdivision.SpecialtyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyEndpointImpl implements SpecialtyEndpoint {

    private final SpecialtyService specialtyService;
    private final SpecialtyMapper specialtyMapper;

    public SpecialtyEndpointImpl(SpecialtyService specialtyService, SpecialtyMapper specialtyMapper) {
        this.specialtyService = specialtyService;
        this.specialtyMapper = specialtyMapper;
    }

    @Override
    @Transactional
    public SpecialtyResponse add(@NonNull SpecialtyCreateRequest request) {
        return specialtyMapper.toSpecialtyResponse(specialtyService.create(request));
    }

    @Override
    @Transactional
    public SpecialtyResponse update(@NonNull Long id, @NonNull SpecialtyUpdateRequest request) {
        return specialtyMapper.toSpecialtyResponse(specialtyService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public SpecialtyResponse getById(@NonNull Long id) {
        return specialtyMapper.toSpecialtyResponse(specialtyService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SpecialtyResponse> getAll() {
        return specialtyService.list()
                .stream()
                .map(specialtyMapper::toSpecialtyResponse)
                .collect(Collectors.toList());

    }
}
