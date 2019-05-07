/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.User;
import tn.esprit.facade.AbstractFacade;
import tn.esprit.iservices.UserFacadeRemote;

/**
 *
 * @author ksamih
 */
@Stateless
@LocalBean
public class UserFacade extends AbstractFacade<User> implements UserFacadeRemote {

    @PersistenceContext(unitName = "Soluc-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User login(String username, String password)
    {
    	User user = new User();
    	
    	try{
    		user = em.createQuery("SELECT U FROM User U WHERE U.username= :username AND U.password= :password", User.class)
    				.setParameter("username", username)
    				.setParameter("password", password)
    				.getSingleResult();
    		
    		return user;
    	}catch(NoResultException ex)
    	{
    		User Error = new User();
    		Error.setEmail("empty");
    		return Error;
    	}
    	
    	
    }
    
}
