package com.stackroute.service;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    public TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track)throws  TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        else {
            Track savedTrack = trackRepository.save(track);
            return savedTrack;
        }

    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public  Optional<Track> getTrackById(int id) throws TrackNotFoundException{
        if(trackRepository.existsById(id)) {
            Optional<Track> getTrack = trackRepository.findById(id);
            return getTrack;
        }
        else
        {
            throw new TrackNotFoundException("Track not present");
        }

    }

    @Override
    public Track updateTrack(Track track,int trackId) {
        Track updatedTrack=trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public List<Track> deleteTrackById(int id) throws TrackNotFoundException {
        if(trackRepository.existsById(id)) {
            trackRepository.deleteById(id);
            return trackRepository.findAll();
        }
        else
        {
            throw new TrackNotFoundException("Track Not found");
        }
    }

    @Override
    public List<Track> findByName(String trackName) throws TrackNotFoundException {
            return trackRepository.findByName(trackName);

    }
}
