package com.example.UserTrackService.controller;



import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.exception.TrackExistException;
import com.example.UserTrackService.exception.TrackNotExistException;
import com.example.UserTrackService.service.TrackServiceInterface;
import com.mongodb.internal.connection.tlschannel.TrackingAllocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class TrackController {


    private TrackServiceInterface trackServiceInterface;

    @Autowired
    public TrackController(TrackServiceInterface trackServiceInterface)
    {
        this.trackServiceInterface = trackServiceInterface;
    }


    // http://localhost:8084/api/v2/track
    @PostMapping("/track")
    public ResponseEntity<?> saveTracks(@RequestBody Track track) throws TrackExistException{
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(trackServiceInterface.saveTrack(track), HttpStatus.CREATED);
        } catch (TrackExistException exception) {
            throw new TrackExistException();
        }
        return responseEntity;
    }

    // http://localhost:8084/api/v1/tracks
    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<>(trackServiceInterface.getAllTrack(), HttpStatus.OK);
    }

   // http://localhost:8084/api/v2/track/{artistName}
    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> getByTrackById(@PathVariable Integer trackId )throws TrackNotExistException
    {
        ResponseEntity responseEntity=null;
        try{
            responseEntity=new ResponseEntity<>(trackServiceInterface.getTrackById(trackId),HttpStatus.FOUND);
        }
        catch(TrackNotExistException exception){
            throw new TrackNotExistException() ;
        }
        return responseEntity;
    }


}