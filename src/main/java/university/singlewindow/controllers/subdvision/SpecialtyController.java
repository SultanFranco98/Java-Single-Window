package university.singlewindow.controllers.subdvision;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.singlewindow.dto.subdivision.specialty.SpecialtyCreateRequest;
import university.singlewindow.dto.subdivision.specialty.SpecialtyResponse;
import university.singlewindow.dto.subdivision.specialty.SpecialtyUpdateRequest;
import university.singlewindow.endpoint.subdvision.SpecialtyEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/specialty")
public class SpecialtyController {

    private final SpecialtyEndpoint specialtyEndpoint;

    public SpecialtyController(SpecialtyEndpoint specialtyEndpoint) {
        this.specialtyEndpoint = specialtyEndpoint;
    }

    @PostMapping
    public ResponseEntity<SpecialtyResponse> create(@RequestBody SpecialtyCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(specialtyEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SpecialtyResponse> put(@PathVariable Long id, @RequestBody SpecialtyUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(specialtyEndpoint.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> destroy(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("{ message: " + specialtyEndpoint.delete(id) + " }");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SpecialtyResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(specialtyEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(specialtyEndpoint.getAll());
    }
}
