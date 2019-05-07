/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Shop;
import tn.esprit.facade.AbstractFacade;
import tn.esprit.iservices.ShopFacadeRemote;

/**
 *
 * @author ksamih
 */
@Stateless
@LocalBean
public class ShopFacade  extends AbstractFacade<Shop> implements ShopFacadeRemote {

    @PersistenceContext(unitName = "Soluc-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShopFacade() {
        super(Shop.class);
    }
   
}
