package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.User;
import org.example.restexam.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        User findUser = userRepository
                .findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getName() != null) findUser.setName(user.getName());
        if (user.getEmail() != null) findUser.setEmail(user.getEmail());

        return findUser; // @Transactional 덕분에 오류 없이 여기까지 수정되면 commit이 일어난다.
        // JPA는 commit 되는 시점에 변경을 감지해서 update를 해준다.
        // save()를 또 요청할 필요가 없다. 이렇게 처리하는 것 보다 변경을 감지해서 처리하는 것이 더 좋음.
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
