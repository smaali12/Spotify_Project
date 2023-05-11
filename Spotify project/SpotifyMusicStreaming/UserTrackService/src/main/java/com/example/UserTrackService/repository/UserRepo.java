package com.example.UserTrackService.repository;

import com.example.UserTrackService.domin.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String>
{
}
