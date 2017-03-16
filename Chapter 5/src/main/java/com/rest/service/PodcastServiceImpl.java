package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.rest.domain.Podcast;
import com.rest.exception.ErrorMessage;
import com.rest.exception.NotFoundException;
import javax.ws.rs.core.*;



public class PodcastServiceImpl implements PodcastService {
    
    static private Map<Integer, Podcast> podcastDB = new ConcurrentHashMap<Integer, Podcast>();
    static private AtomicInteger idCounter = new AtomicInteger();
        
    // get podcast by id
    public Podcast getPodcast(int id) throws NotFoundException {
        Podcast podcast = podcastDB.get(id);
        if (podcast == null) {
             ErrorMessage errorMessage = new ErrorMessage("1001", "Podcast not found!", "http://localhost:8080/lab3/error.jsp", Response.Status.NOT_FOUND);
              
             throw new NotFoundException(errorMessage);
          }
         
        return podcast;
    }
     
    // add podcast
    public void createPodcast(Podcast podcast) {
        
        podcast.setId(idCounter.incrementAndGet());
        podcastDB.put(podcast.getId(), podcast);
         
    }
     
    // update podcast
    public void updatePodcast(int id, Podcast update)  {
        
        Podcast current = podcastDB.get(id);
         
          current.setDescription(update.getDescription());
          current.setTitle(update.getTitle());
          current.setFeed(update.getFeed());
          current.setLink(update.getLink());
          
           
          podcastDB.put(current.getId(), current);
        
    }
     
    // Delete podcast
    public void deletePodcast(int id) {
         
        Podcast current = podcastDB.remove(id);
           
    }
     
   // Search podcast
   public List<Podcast> getPodcasts(String title) {
             
       List<Podcast> podcastList = new ArrayList<Podcast>(podcastDB.values());
       List<Podcast> titleMatchedList = new ArrayList<Podcast>();
        
       for(int i = 0; i < podcastList.size(); i++)
       {
           Podcast podcast = podcastList.get(i);
           if ( podcast.getTitle().contains(title) )
               titleMatchedList.add(podcast);
                    
       }
        
       return titleMatchedList;
            
   }
     
} 
