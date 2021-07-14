package com.qhala.exercise.services;

import com.qhala.exercise.entities.Book;
import com.qhala.exercise.entities.Video;
import com.qhala.exercise.repositories.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video addVideo(Video video){
        return videoRepository.save(video);
    }

    public List<Video> getAll(){
        return videoRepository.findAll();
    }

    public Optional<Book> findById(Long id){

        return videoRepository.findById(id);
    }

}
