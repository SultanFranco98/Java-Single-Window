package university.singlewindow.endpoint.subdvision;

import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.dto.subdivision.faculty.FacultyResponse;

import java.util.List;

public interface FacultyEndpoint {
    FacultyResponse add(FacultyCreateRequest request);
    List<FacultyResponse> getAll();
}
