package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track track);
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int id);
    public  Track updateTrack(Track track,int trackId);
    public List<Track> deleteTrackById(int id);


}
