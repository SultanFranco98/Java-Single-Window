package university.singlewindow.services.subdivision.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.entity.subdivision.Faculty;
import university.singlewindow.repositories.subdivision.FacultyRepository;
import university.singlewindow.services.subdivision.FacultyService;

import java.time.LocalDateTime;
import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    @Transactional
    public Faculty create(@NonNull FacultyCreateRequest request) {
        Faculty faculty = new Faculty();
        faculty.setTitle(request.getTitle());
        faculty.setCreateAt(LocalDateTime.now());
        return facultyRepository.save(faculty);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Faculty> list() {
        return facultyRepository.findAll();
    }
}
