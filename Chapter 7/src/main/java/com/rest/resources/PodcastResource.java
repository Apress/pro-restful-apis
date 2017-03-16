package com.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.domain.Podcast;
import com.rest.exception.NotFoundException;
import com.rest.service.PodcastService;

@Path("podcasts")
public class PodcastResource {
    
     
     
    @Autowired
    PodcastService podcastService;
     
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Podcast createPodcast(Podcast podcast) {
         
        podcastService.createPodcast(podcast);
        return podcast;
    }
   
  
    @GET
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Podcast getPodcast(@PathParam("id") int id) throws NotFoundException {
      Podcast podcast = podcastService.getPodcast(id);
       return podcast;
    }
     
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public List<Podcast> getPodcasts(@QueryParam("title") String title) {
      List<Podcast> podcasts = podcastService.getPodcasts(title);
       return podcasts;
    }
  
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public void updatePodcast(@PathParam("id") int id, Podcast update) {
       podcastService.updatePodcast(id, update);
    }
     
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public void deletePodcast(@PathParam("id") int id)  {
      podcastService.deletePodcast(id);
    }
}

