package com.security.SecurityFeature.implemented.Repo;


import com.security.SecurityFeature.implemented.Modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
