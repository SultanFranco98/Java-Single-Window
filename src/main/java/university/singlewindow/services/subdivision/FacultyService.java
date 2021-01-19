package university.singlewindow.services.subdivision;

import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.entity.subdivision.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty create(FacultyCreateRequest request);
    List<Faculty> list();
}
