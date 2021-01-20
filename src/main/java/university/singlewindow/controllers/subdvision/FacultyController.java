package university.singlewindow.controllers.subdvision;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.singlewindow.dto.subdivision.faculty.FacultyCreateRequest;
import university.singlewindow.dto.subdivision.faculty.FacultyResponse;
import university.singlewindow.endpoint.subdvision.FacultyEndpoint;
import university.singlewindow.entity.subdivision.Faculty;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {

    private final FacultyEndpoint facultyEndpoint;

    public FacultyController(FacultyEndpoint facultyEndpoint) {
        this.facultyEndpoint = facultyEndpoint;
    }

    @PostMapping
    public ResponseEntity<FacultyResponse> create(@RequestBody FacultyCreateRequest request) {
        return ResponseEntity.ok(facultyEndpoint.add(request));
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponse>> list() {
        return ResponseEntity.ok(facultyEndpoint.getAll());
    }
}
