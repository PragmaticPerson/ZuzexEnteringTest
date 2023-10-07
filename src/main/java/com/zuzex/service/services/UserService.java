package com.zuzex.service.services;

import com.zuzex.exceptions.model.EntityNotFoundException;
import com.zuzex.jpa.UserJpaRepository;
import com.zuzex.service.models.DTO.UserRequest;
import com.zuzex.service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    private UserJpaRepository repository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserJpaRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username);
    }

    public User save(UserRequest request) {
        var user = new User();
        fillInAttributes(user, request);
        return repository.save(user);
    }

    public User getUserById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    private void fillInAttributes(User user, UserRequest request) {
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPassword(encoder.encode(request.getPassword()));
    }
}
