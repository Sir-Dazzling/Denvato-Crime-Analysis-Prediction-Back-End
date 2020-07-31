package com.example.denvatocrimeanalyticsplatform.security.services;


import com.example.denvatocrimeanalyticsplatform.dao.UserRepository;
import com.example.denvatocrimeanalyticsplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsernameOrEmail(String usernameOrEmail) throws UsernameNotFoundException
//    {
//        User user = userRepository.findByUsernameOrEmail(usernameOrEmail)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username or email: " + usernameOrEmail));
//
//        return UserDetailsImpl.build(user);
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username or username: " + username));

        return UserDetailsImpl.build(user);
    }
}
