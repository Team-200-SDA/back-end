package se.kth.sda.ta.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void register(User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateAddress(User updatedUser) {
        return userRepository.save(updatedUser);
    }
    public User updatePhoneno(User updatedUser) {
        return userRepository.save(updatedUser);
    }
    public User updateProfilepic(User updatedUser) {
        return userRepository.save(updatedUser);
    }

}
