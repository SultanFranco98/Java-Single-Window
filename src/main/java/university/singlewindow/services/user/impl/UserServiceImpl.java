package university.singlewindow.services.user.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.singlewindow.entity.user.User;
import university.singlewindow.exceptions.ResourceNotFoundException;
import university.singlewindow.repositories.user.UserRepository;
import university.singlewindow.services.user.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(@NonNull Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id " + id + " does not exist"
                ));
    }
}
