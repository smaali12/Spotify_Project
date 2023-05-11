package com.example.UserTrackService.repository;


import com.example.UserTrackService.domin.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepoInterface extends MongoRepository<Track,Integer> {



}
