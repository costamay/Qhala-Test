package com.qhala.exercise.repositories;

import com.qhala.exercise.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository  extends JpaRepository<Video, Long> {
}
