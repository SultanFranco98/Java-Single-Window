package university.singlewindow.endpoint.subdvision;

import university.singlewindow.dto.subdivision.specialty.SpecialtyCreateRequest;
import university.singlewindow.dto.subdivision.specialty.SpecialtyResponse;
import university.singlewindow.dto.subdivision.specialty.SpecialtyUpdateRequest;

import java.util.List;

public interface SpecialtyEndpoint {
    SpecialtyResponse add(SpecialtyCreateRequest request);
    SpecialtyResponse update(Long id, SpecialtyUpdateRequest request);
    SpecialtyResponse getById(Long id);
    List<SpecialtyResponse> getAll();
}
