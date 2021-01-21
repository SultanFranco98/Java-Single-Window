package university.singlewindow.services.user.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.entity.user.Student;
import university.singlewindow.repositories.user.StudentRepository;
import university.singlewindow.services.user.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Student getById(@NonNull Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + id + " does not exist"
                ));
    }
}
