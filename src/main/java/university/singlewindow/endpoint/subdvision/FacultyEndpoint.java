package university.singlewindow.endpoint.subdvision;

import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.dto.subdivision.faculty.FacultyResponse;
import university.singlewindow.dto.subdivision.faculty.FacultyUpdateRequest;

import java.util.List;

public interface FacultyEndpoint {
    FacultyResponse add(FacultyCreateRequest request);
    FacultyResponse update(FacultyUpdateRequest request);
    FacultyResponse getById(Long id);
    List<FacultyResponse> getAll();
}
