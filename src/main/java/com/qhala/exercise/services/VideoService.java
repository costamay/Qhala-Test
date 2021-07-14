package com.qhala.exercise.services;

import com.qhala.exercise.entities.Video;
import com.qhala.exercise.repositories.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video addVideo(Video video){
        return videoRepository.save(video);
    }

    public List<Video> getAll(){
        return videoRepository.findAll();
    }


}
