package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GalleryItem;


public class GalleryItemHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ArtGalleryRice");
	
	
	public void insertItem(GalleryItem toAdd) {
		// TODO Auto-generated method stub
		
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}


		public List<GalleryItem> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<GalleryItem> allResults = em.createQuery("select gi from GalleryItem gi", GalleryItem.class);
		List<GalleryItem> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
		
		public void deleteItem(GalleryItem toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<GalleryItem> typedQuery = em.createQuery("select gi from GalleryItem gi where gi.title = :selectedTitle", GalleryItem.class);
			typedQuery.setParameter("selectedTitle", toDelete.getTitle());
			typedQuery.setMaxResults(1);
			GalleryItem result = typedQuery.getSingleResult();
			System.out.println(result);
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}


		public GalleryItem searchForItemById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			GalleryItem foundItem = em.find(GalleryItem.class, idToEdit);
			em.close();
			return foundItem;
		}


		public void updateItem(GalleryItem itemToUpdate) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(itemToUpdate);
			em.getTransaction().commit();
			em.close();
			// TODO Auto-generated method stub
			
		}
}
