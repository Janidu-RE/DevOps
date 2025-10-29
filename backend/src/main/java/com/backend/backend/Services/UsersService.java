package com.backend.backend.Services;

import com.backend.backend.DTO.LoginRequest;
import com.backend.backend.DTO.SignupRequest;
import com.backend.backend.Repository.UsersRepository;
import com.backend.backend.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> AllUsers(){
        return usersRepository.findAll();
    }

    public Optional<Users> findById(ObjectId objectId){
        return usersRepository.findById(objectId);
    }

    public Optional<Users> findByUsernameOrEmail(String usernameOrEmail){
        return usersRepository.findByUsernameIgnoreCaseOrEmailIgnoreCase(usernameOrEmail,usernameOrEmail);
    }

    public Users RegisterUser (SignupRequest signupRequest){
        if(usersRepository.existsByUsername(signupRequest.getUsername())){
            throw new RuntimeException("Username already taken!");
        }
        if(usersRepository.existsByEmail(signupRequest.getEmail())){
            throw new RuntimeException("Email already taken!");
        }

        Users user = new Users();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());

        return usersRepository.save(user);
    }

    public Users Login(LoginRequest loginRequest){
        Optional<Users> optionalUser = usersRepository.findByUsernameIgnoreCaseOrEmailIgnoreCase(loginRequest.getUsernameOrEmail(),loginRequest.getUsernameOrEmail());
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User not found!");
        }
        Users user = optionalUser.get();
        boolean matches = loginRequest.getPassword().equals(user.getPassword());
        if(!matches){
            throw new RuntimeException("Password is incorrect!");
        }
        return user;
    }
}
