package university.singlewindow.services.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.dto.subdivision.faculty.FacultyUpdateRequest;
import university.singlewindow.entity.subdivision.Faculty;
import university.singlewindow.exceptions.ResourceNotFoundException;
import university.singlewindow.repositories.subdivision.FacultyRepository;
import university.singlewindow.services.subdivision.FacultyService;

import java.time.LocalDateTime;
import java.util.List;

@Service
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
    @Transactional
    public Faculty put(@NonNull Long id, @NonNull FacultyUpdateRequest request) {
        Faculty faculty = retrieve(id);
        faculty.setTitle(request.getTitle());
        faculty.setUpdateAt(LocalDateTime.now());
        return facultyRepository.save(faculty);
    }

    @Override
    @Transactional
    public String destroy(@NonNull Long id) {
        Faculty faculty = retrieve(id);
        facultyRepository.deleteById(faculty.getId());
        return "Faculty with id " + id + " removed";
    }

    @Override
    @Transactional(readOnly = true)
    public Faculty retrieve(@NonNull Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Faculty with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Faculty> list() {
        return facultyRepository.findAll();
    }
}
