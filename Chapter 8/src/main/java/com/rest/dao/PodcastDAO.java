
package com.rest.dao;

import java.util.List;

import com.rest.domain.Podcast;
import com.rest.exception.NotFoundException;

public interface PodcastDAO {
	public void createPodcast(Podcast podcast);
	public Podcast getPodcast(int id) throws NotFoundException;
	public Podcast deletePodcast(int id);
	public Podcast updatePodcast(int id, Podcast update);
	public List<Podcast> getAll();
	public List<Podcast> getPodcastByTitle(String title);
}
