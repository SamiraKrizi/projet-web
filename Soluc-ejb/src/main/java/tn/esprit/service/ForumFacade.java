package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Forum;
import tn.esprit.facade.AbstractFacade;
import tn.esprit.iservices.ForumFacadeRemote;

@Stateless
@LocalBean
public class ForumFacade extends AbstractFacade<Forum> implements ForumFacadeRemote {

	@PersistenceContext(unitName = "Soluc-ejb")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	    return em;
	}
	
	public ForumFacade() {
	    super(Forum.class);
	}

	@Override
	public Forum find(Forum forum) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
