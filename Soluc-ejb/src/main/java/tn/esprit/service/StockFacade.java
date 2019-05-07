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
import tn.esprit.entities.Stock;
import tn.esprit.iservices.StockFacadeRemote;

/**
 *
 * @author ksamih
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeRemote {

    @PersistenceContext(unitName = "Soluc-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    
}
