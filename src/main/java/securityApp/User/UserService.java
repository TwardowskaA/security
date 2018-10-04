package securityApp.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public void addUser(String login, String password, String firstName, String lastName) {
        User user = new User(login, "{noop}"+ password,firstName,lastName);
        userRepository.save(user);

        UserRole userRole = new UserRole(login,"ROLE_USER");
        userRoleRepository.save(userRole);
    }

}