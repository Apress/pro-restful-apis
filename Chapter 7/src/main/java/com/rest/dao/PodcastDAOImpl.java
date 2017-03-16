package com.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import javax.ws.rs.core.Response;

import com.rest.domain.Podcast;

import com.rest.exception.ErrorMessage;
import com.rest.exception.NotFoundException;


public class PodcastDAOImpl implements PodcastDAO {
	 private static final String PERSISTENCE_UNIT_NAME = "Podcast";
     private static EntityManagerFactory factory;

    public void createPodcast(Podcast podcastx) {
          factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          EntityManager em = factory.createEntityManager();
          // Read the existing entries and write to console
          Query q = em.createQuery("SELECT p FROM Podcast p");
          @SuppressWarnings("unchecked")
		  List<Podcast> podcastList = q.getResultList();
          for (Podcast podcast : podcastList) {
               System.out.println(podcast.getTitle());
          }
          System.out.println("Size: " + podcastList.size());

          // Create new user
          em.getTransaction().begin();
          Podcast podcast = new Podcast();
          podcast.setTitle(podcastx.getTitle());
          podcast.setDescription(podcastx.getDescription());
          podcast.setFeed(podcastx.getFeed());
          podcast.setLink(podcastx.getLink());
          em.persist(podcast);
          em.getTransaction().commit();
          em.close();
    }
    
	public Podcast getPodcast(int id) throws NotFoundException {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
    	Podcast podcast = em.getReference(Podcast.class, id);
    	if (podcast == null ) {
    		ErrorMessage errorMessage = new ErrorMessage("1001", "Podcast not found!", "http://localhost:8080/lab6/error.jsp", Response.Status.NOT_FOUND);
    			throw new NotFoundException(errorMessage);
    	}
    	return podcast; 
	}

	public Podcast deletePodcast(int id) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Podcast podcast = em.find(Podcast.class, id);
        
        em.getTransaction().begin();
        em.remove(podcast);
        em.getTransaction().commit();
        
        return podcast;
	}

	public Podcast updatePodcast(int id, Podcast update) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Podcast podcast = em.find(Podcast.class, id);
        
        em.getTransaction().begin();
        podcast.setTitle(update.getTitle());
        podcast.setDescription(update.getDescription());
        podcast.setFeed(update.getFeed());;
        podcast.setLink(update.getLink());;
        em.getTransaction().commit();
        return podcast;
	}

    // get all
		@SuppressWarnings("unchecked")
		public List<Podcast> getAll() {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
		    Query query = em.createQuery("SELECT e FROM Podcast e");
		    return (List<Podcast>) query.getResultList();
		  }
	
	
	// get all
		
		@SuppressWarnings("unchecked")
		public List<Podcast> getPodcastByTitle(String title) throws NotFoundException {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
		    
		    
		    	return (List<Podcast>) em.createQuery(
		    	    "SELECT p FROM Podcast p  WHERE p.title LIKE :title")
		    	    .setParameter("title", title)
		    	    .setMaxResults(10)
		    	    .getResultList();
		    	
		    
	}
}
