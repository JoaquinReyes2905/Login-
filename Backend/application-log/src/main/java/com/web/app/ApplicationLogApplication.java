package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.web.app.models.*;
import com.web.app.Repo.UserRepo;

@SpringBootApplication
public class ApplicationLogApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLogApplication.class, args);
	}
}
