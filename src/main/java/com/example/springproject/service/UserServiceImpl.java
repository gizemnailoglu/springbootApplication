package com.example.springproject.service;

import com.example.springproject.domainObject.User;
import com.example.springproject.domainObject.rule;
import com.example.springproject.dto.UserDTO;
import com.example.springproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired(required =false )
    private ModelMapper modelMapper;



    @Override
    public User createUser(User user) {

        User newUser = user;
        return userRepository.save(newUser);
    }


//    }
//
    @Override
    public UserDTO updateUser(User user) {

        long userId = user.getId();
        Optional<User> currentUser = userRepository.findById(userId);
        if (currentUser.isPresent()) {

            currentUser.get().setUsername(user.getUsername());
            currentUser.get().setName(user.getName());
            currentUser.get().setEmail(user.getEmail());
            currentUser.get().setPassword(user.getPassword());
            currentUser.get().setSurname(user.getSurname());
          currentUser.get().setRol(user.getRol());
            userRepository.save(currentUser.get());

            UserDTO userDTO = new ModelMapper().map(currentUser.get() ,UserDTO.class);

            return  userDTO;
        }




    return null;
    }



    @Override
    public void deleteUser(Long userId) {
      Optional<User> currentUser = userRepository.findById(userId);
      if(currentUser.isPresent()){
          userRepository.deleteById(userId);
      }
    }


    @Override
    public User getUser(Long userId) {
            Optional<User> currentUser = userRepository.findById(userId);
            if (currentUser.isPresent()) {
                return currentUser.get();
            }
            return null;
    }

    @Override
    public User getUser(String username) {
        Optional<User> currentUser = userRepository.findByUsername(username);
        if (currentUser.isPresent()) {
            return currentUser.get();
        }
        return null;
    }

    @Override
    public Boolean Login(String username, String pass) {
        Optional<User> currentUser = userRepository.findByUsername(username);
        if (currentUser.isPresent()) {

            if(currentUser.get().getPassword().equals(pass))
            {

                return  true;
            }

            return  false;
        }
        else
        {
            System.out.println("nesne yok");
        }
        return false;

    }


    public User getUserByEmail(String email) {
        Optional<User> currentUser = userRepository.findByEmail(email);
        if (currentUser.isPresent()) {
            return currentUser.get();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {


        List<User>users =  userRepository.findAll();


        int len = users.size();
        

        for(int i =0; i<len ; i++ )
        {

            User usr = users.get(i);

            if(usr.getPassword() == null)
            {
                usr.setRol(rule.GUEST);
            }
            else
            {
                if(usr.getRol() != rule.ADMIN)
                {
                    usr.setRol(rule.USER);
                }
            }

            users.set(i,usr);



        }


        return users;
    }

    public void saveUser(User user) {

        userRepository.save(user);
    }
}

