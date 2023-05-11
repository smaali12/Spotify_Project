package com.example.UserTrackService.service;


import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.exception.TrackExistException;
import com.example.UserTrackService.exception.TrackNotExistException;

import java.util.List;
import java.util.Optional;

public interface TrackServiceInterface {

    public List<Track> getAllTrack();
    public Track saveTrack(Track track)throws TrackExistException;
    public Track getTrackById(Integer id)throws TrackNotExistException;
}
