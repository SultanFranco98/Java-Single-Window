package university.singlewindow.controllers.subdvision;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.singlewindow.dto.subdivision.group.GroupCreateRequest;
import university.singlewindow.dto.subdivision.group.GroupResponse;
import university.singlewindow.dto.subdivision.group.GroupUpdateRequest;
import university.singlewindow.endpoint.subdvision.GroupEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/group")
public class GroupController {

    private final GroupEndpoint groupEndpoint;

    public GroupController(GroupEndpoint groupEndpoint) {
        this.groupEndpoint = groupEndpoint;
    }

    @PostMapping
    public ResponseEntity<GroupResponse> create(@RequestBody GroupCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GroupResponse> put(@PathVariable Long id, @RequestBody GroupUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(groupEndpoint.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> destroy(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(groupEndpoint.delete(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GroupResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(groupEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(groupEndpoint.getAll());
    }
}
