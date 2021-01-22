package university.singlewindow.services.subdivision;

import university.singlewindow.dto.subdivision.specialty.SpecialtyCreateRequest;
import university.singlewindow.dto.subdivision.specialty.SpecialtyResponse;
import university.singlewindow.dto.subdivision.specialty.SpecialtyUpdateRequest;
import university.singlewindow.entity.subdivision.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty create(SpecialtyCreateRequest request);
    void destroy(Long id);
    Specialty retrieve(Long id);
    Specialty put(Long id, SpecialtyUpdateRequest request);
    List<Specialty> list();
}
