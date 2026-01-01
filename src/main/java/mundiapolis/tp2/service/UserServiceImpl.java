package mundiapolis.tp2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mundiapolis.tp2.entities.Role;
import mundiapolis.tp2.entities.User;
import mundiapolis.tp2.repositories.RoleRepository;
import mundiapolis.tp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor // Generates constructor for dependency injection
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
    @Autowired

    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);     }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);

        if (user.getRoles() != null )
        {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

     //   userRepository.save(user);

    }

    @Override
    public User authenticateUser(String userName, String password)
    {
        User user = userRepository.findByUserName(userName);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password))
        {
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}