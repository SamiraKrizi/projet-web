/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.service;

import tn.esprit.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.entities.Promotion;
import tn.esprit.iservices.PromotionFacadeRemote;

/**
 *
 * @author ksamih
 */
@Stateless
public class PromotionFacade extends AbstractFacade<Promotion> implements PromotionFacadeRemote {

    @PersistenceContext(unitName = "Soluc-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }
    
}
