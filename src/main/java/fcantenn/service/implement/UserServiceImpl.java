package fcantenn.service.implement;

import fcantenn.exception.UserAlreadyExistException;
import fcantenn.model.Role;
import fcantenn.model.User;
import fcantenn.repository.IRoleRepository;
import fcantenn.repository.IUserRepository;
import fcantenn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired private BCryptPasswordEncoder encoder;

    @Autowired
    private IRoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found or the email was been verified");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Collection<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    @Override
    public User findByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public void registerNewUserAccount(User user) throws UserAlreadyExistException {
        if (usernameExists(user.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: " + user.getUsername());
        }
        saveUser(user);
    }

    private void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public void registerNewUserAccountStaff(User user) throws UserAlreadyExistException {
        if (usernameExists(user.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: " + user.getUsername());
        }
        saveUserStaff(user);
    }

    private void saveUserStaff(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("ROLE_STAFF");
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
