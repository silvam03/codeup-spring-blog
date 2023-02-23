//package com.codeup.codeupspringblog.services;
//
//import com.codeup.codeupspringblog.models.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsLoader implements UserDetailsService {
//
//    private final UserRepository userDao;
//
//    public UserDetailsLoader(UserRepository userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userDao.findByUsername(username);
//        if(user == null) {
//            throw new UsernameNotFoundException("No user found for " + username);
//        }
//        return new UserWithRoles(user);
//    }
//
//}
