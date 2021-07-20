package com.qhala.exercise.services;

import com.qhala.exercise.entities.User;
import com.qhala.exercise.entities.Video;
import com.qhala.exercise.exceptions.ResourceNotFoundException;
import com.qhala.exercise.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public Video addVideo(Video video){
        return videoRepository.save(video);
    }

    public List<Video> getAll(){
        return videoRepository.findAll();
    }

    public Video findVideoById(Long id){

        return videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
    }

    public void  deleteVideoById(Long id){
        videoRepository.deleteById(id);
    }

}
