/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.service;

import java.util.List;
import tn.esprit.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReponseReclamation;
import tn.esprit.iservices.ReponseReclamationFacadeRemote;

/**
 *
 * @author ksamih
 */
@Stateless
public class ReponseReclamationFacade extends AbstractFacade<ReponseReclamation> implements ReponseReclamationFacadeRemote {

    @PersistenceContext(unitName = "Soluc-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReponseReclamationFacade() {
        super(ReponseReclamation.class);
    }

    @Override
    public int AddReponse(ReponseReclamation reponse) {
        em.persist(reponse);
        return reponse.getIdReponse();
    }

    @Override
    public int RemoveReponse(ReponseReclamation reponse) {
        return em.createQuery("DELETE FROM ReponseReclamation WHERE idReponse= :id").setParameter("id", reponse.getIdReponse()).executeUpdate();
    }

    @Override
    public List<ReponseReclamation> FindReponseByidReclamation(int id) {
        return em.createQuery("select r from ReponseReclamation r where r.idReclamation= :id order By r.dateReponse ASC", ReponseReclamation.class).setParameter("id", id).getResultList();
    }

    @Override
    public int CalculTotalReponse(int idReclamation) {
        Long lol = em.createQuery("select count(r) from ReponseReclamation r where r.idReclamation= :id", Long.class).setParameter("id", idReclamation).getSingleResult();
        return lol.intValue();
    }

    @Override
    public ReponseReclamation getResponse(Reclamation rec) {
        ReponseReclamation response = new ReponseReclamation();
        
        try{
            response = (ReponseReclamation) em.createQuery("SELECT R FROM ReponseReclamation R where R.reclamation = :rec" , ReponseReclamation.class)
                    .setParameter("rec", rec)
                    .getSingleResult();
            System.out.println(response);
            return response;
        }catch(NoResultException ex)
        {
            return new ReponseReclamation();
        }
    }

}
