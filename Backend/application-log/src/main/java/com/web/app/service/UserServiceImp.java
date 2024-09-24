package com.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.Repo.UserRepo;
import com.web.app.models.Users;

@Service
public class UserServiceImp {

	@Autowired
	private UserRepo repository;
	
	public List<Users> GetAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Users createUser(Users user) {
        return repository.save(user);
    }
	public Users getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Users updateUser(Long id, Users user) {
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
