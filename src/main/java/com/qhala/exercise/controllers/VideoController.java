package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.Video;
import com.qhala.exercise.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @PostMapping("video/create")
    public Video addVideo(@RequestBody Video video){
        return videoService.addVideo(video);
    }

    @GetMapping("/video/all")
    public List<Video> getAll(){
        return videoService.getAll();
    }

}
