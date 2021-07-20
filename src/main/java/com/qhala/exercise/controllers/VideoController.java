package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.User;
import com.qhala.exercise.entities.Video;
import com.qhala.exercise.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @PostMapping("video/create")
    public ResponseEntity<?> addVideo(@RequestBody Video video){
        Video videoSaved = videoService.addVideo(video);
        return new ResponseEntity<Video>(videoSaved,HttpStatus.CREATED);
    }

    @GetMapping("/video/all")
    public ResponseEntity<List<Video>> getAll(){
        List<Video> listOfVideos = videoService.getAll();
        return new ResponseEntity<List<Video>>(listOfVideos, HttpStatus.OK);
    }

    @GetMapping("video/find/{id}")
    public  ResponseEntity<?> findVideoById(@PathVariable("id") Long id){
        Video videoRetrieved = videoService.findVideoById(id);
        return new ResponseEntity<Video>(videoRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/video/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        videoService.deleteVideoById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


}
