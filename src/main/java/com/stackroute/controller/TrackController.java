package com.stackroute.controller;
import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        trackService.saveTrack(track);
        responseEntity= new ResponseEntity<String>("Successfully saved", HttpStatus.OK);
    return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<List<Track>> getAllTracks(){
         ResponseEntity responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    return responseEntity;
    }

    @PutMapping("update/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable("trackId") int trackId )
    {
        ResponseEntity responseEntity;
        trackService.updateTrack(track,trackId);
        responseEntity=new ResponseEntity<String>("Successfully Updated",HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("delete/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackId") int trackId )
    {
        trackService.deleteTrackById(trackId);
        ResponseEntity responseEntity;
        responseEntity=new  ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable("trackId") int trackId)
    {
        ResponseEntity responseEntity;
        trackService.getTrackById(trackId);
        responseEntity=new ResponseEntity<Optional<Track>>(trackService.getTrackById(trackId),HttpStatus.OK);
        return responseEntity;
    }


}
