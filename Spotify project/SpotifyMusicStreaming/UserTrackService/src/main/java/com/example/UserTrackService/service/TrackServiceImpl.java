package com.example.UserTrackService.service;


import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.exception.TrackExistException;
import com.example.UserTrackService.exception.TrackNotExistException;
import com.example.UserTrackService.repository.TrackRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackServiceInterface {

    private TrackRepoInterface trackRepoInterface;
    @Autowired
    public TrackServiceImpl(TrackRepoInterface trackRepoInterface) {
        this.trackRepoInterface = trackRepoInterface;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepoInterface.findAll();
    }

    @Override
    public Track saveTrack(Track track) throws TrackExistException {
        if(trackRepoInterface.findById(track.getTrackId()).isPresent())
        {
            throw new TrackExistException();
        }
        return trackRepoInterface.save(track);
    }


    @Override
    public Track getTrackById(Integer trackId) throws TrackNotExistException {

        if (trackRepoInterface.findById(trackId).isEmpty())
            throw new TrackNotExistException();
        else {
            return trackRepoInterface.findById(trackId).get();
        }
    }

}

