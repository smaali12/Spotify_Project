package com.example.UserAuth.repository;


import com.example.UserAuth.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoInterface extends JpaRepository<User,String> {

}
