package dev.ak.springsecurity.service;

import dev.ak.springsecurity.entity.UserAuth;
import dev.ak.springsecurity.repository.UserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public UserDetails saveUser(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public UserAuth loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findByUsername(username);
    }
}
