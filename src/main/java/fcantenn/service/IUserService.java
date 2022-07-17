package fcantenn.service;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends UserDetailsService {
    User findByUsername(String email);

    void registerNewUserAccount(User user) throws UserAlreadyExistException;
    void registerNewUserAccountStaff(User user) throws  UserAlreadyExistException;
}
