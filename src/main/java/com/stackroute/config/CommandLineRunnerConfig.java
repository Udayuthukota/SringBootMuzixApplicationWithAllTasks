package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommandLineRunnerConfig implements org.springframework.boot.CommandLineRunner {

    TrackService trackService;

    @Autowired
    public CommandLineRunnerConfig(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String args[]) throws Exception {
        Track track = new Track();
        track.setTrackId(1);
        track.setTrackName("default CommandLineRunner");
        track.setTrackComment("default Line Runner comments");
        try {
            trackService.saveTrack(track);
        } catch (Exception e) {
        }
    }

}