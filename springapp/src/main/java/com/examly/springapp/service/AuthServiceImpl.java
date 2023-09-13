package com.examly.springapp.service;

import com.examly.springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Login;
import com.examly.springapp.model.Admin;
import com.examly.springapp.repository.AdminRepository;
import com.examly.springapp.repository.LoginRepository;
import com.examly.springapp.repository.AuthRepository;



import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService { // Remove "abstract" keyword
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public User saveUser(User user){
        User savedUser = authRepository.save(user);
        Login login = new Login();
        login.setUsername(user.getUsername());
        login.setPassword(user.getPassword());
        // Set the user reference for Login
        login.setUser(user);

        // Save the login entity
        loginRepository.save(login);
        return savedUser;
    }
    
    @Override
    public User saveAdmin(User user) {
        User savedUser = authRepository.save(user);

        // Check if the user has the role "admin"
        if ("admin".equals(savedUser.getUserRole())) {
            Admin admin = new Admin();
            admin.setEmail(savedUser.getEmail());
            admin.setPassword(savedUser.getPassword());
            admin.setMobileNumber(savedUser.getMobileNumber());
            admin.setUserRole(savedUser.getUserRole());

            // Set other fields as needed

            adminRepository.save(admin);
            
        }
        return savedUser;
    }

    // @Override
    // public User saveAdmin(User adminUser){
    //     return authRepository.save(adminUser);
    // }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return authRepository.findByEmailAndPasswordAndUserRole(email, password,"user");
    }

    @Override
    public Optional<User> getAdminByEmailAndPassword(String email, String password) {
        return authRepository.findByEmailAndPasswordAndUserRole(email, password, "admin");
    }
    @Override
    public Optional<User> getUserByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers(){
        return authRepository.findAll();
    }

    // Create a Login entity and duplicate username and password
    
}
