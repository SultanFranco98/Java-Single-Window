package university.singlewindow.services.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.dto.subdivision.specialty.SpecialtyCreateRequest;
import university.singlewindow.dto.subdivision.specialty.SpecialtyUpdateRequest;
import university.singlewindow.entity.subdivision.Specialty;
import university.singlewindow.exceptions.ResourceNotFoundException;
import university.singlewindow.repositories.subdivision.SpecialtyRepository;
import university.singlewindow.services.subdivision.SpecialtyService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty create(@NonNull SpecialtyCreateRequest request) {
        Specialty specialty = new Specialty();
        specialty.setTitle(request.getTitle());
        specialty.setFaculty(request.getFaculty());
        specialty.setCreateAt(LocalDateTime.now());
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty put(@NonNull Long id, @NonNull SpecialtyUpdateRequest request) {
        Specialty specialty = retrieve(id);
        specialty.setTitle(request.getTitle());
        specialty.setFaculty(request.getFaculty());
        specialty.setUpdateAt(LocalDateTime.now());
        return specialtyRepository.save(specialty);
    }

    @Override
    @Transactional(readOnly = true)
    public Specialty retrieve(@NonNull Long id) {
        return specialtyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Specialty with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Specialty> list() {
        return specialtyRepository.findAll();
    }
}
