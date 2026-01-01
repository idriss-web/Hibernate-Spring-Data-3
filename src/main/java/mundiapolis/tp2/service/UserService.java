package mundiapolis.tp2.service;

import mundiapolis.tp2.entities.Role;
import mundiapolis.tp2.entities.User;

public interface UserService {

    User addNewUser(User user);

    Role addNewRole(Role role);

    User findUserByUserName(String userName);

    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String username, String roleName);

    User authenticateUser(String userName, String password);
}
