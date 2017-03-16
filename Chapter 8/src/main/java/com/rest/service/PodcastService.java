package com.rest.service;

import java.util.List;

import com.rest.domain.Podcast;
import com.rest.exception.NotFoundException;

public interface PodcastService {
    public Podcast getPodcast(int id) throws NotFoundException;
    public void createPodcast(Podcast podcast);
    public void updatePodcast(int id, Podcast update);
    public void deletePodcast(int id);
    public List<Podcast> getPodcasts(String title);
}
