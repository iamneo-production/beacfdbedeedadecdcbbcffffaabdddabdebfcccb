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
     public User saveAdmin(User adminUser){
        User savedAdmin = authRepository.save(adminUser);
        Admin admin = new Admin();
         return authRepository.save(adminUser);
         if (adminUser.getUserRole().equals("admin")){
            
         }
     }
    
    // public void duplicateAdmins() {
    //     List<User> usersWithAdminRole = userRepository.findByUserRole("admin");
        
    //     for (User user : usersWithAdminRole) {
    //         Admin admin = new Admin();
    //         admin.setUsername(user.getUsername());
    //         admin.setPassword(user.getPassword());
    //         admin.setUserRole(user.getUserRole());
            
    //         adminRepository.save(admin);
    //     }
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
