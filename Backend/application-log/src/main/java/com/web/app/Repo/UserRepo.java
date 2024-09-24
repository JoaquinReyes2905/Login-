package com.web.app.Repo;

import com.web.app.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> 	{

}
