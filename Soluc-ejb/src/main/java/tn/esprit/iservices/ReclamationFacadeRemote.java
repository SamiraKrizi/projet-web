/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.iservices;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.entities.EtatReclamation;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.TypeReclamation;

/**
 *
 * @author ksamih
 */
@Remote
public interface ReclamationFacadeRemote {

  void create(Reclamation r);
    
    public int addReclamation(Reclamation r);

    public List<Reclamation> All();

    public List<Reclamation> FindByType(TypeReclamation type);

    public int EditEtat(int idReclamation, EtatReclamation etat);

    public Reclamation FindByNomOuPrenomUser(String nom, String prenom);

    public Reclamation FindByUsername(String UserName);

    public int CalculNombreTotalReclamationSelonType(TypeReclamation type);

    public int CalculNombreTotalReclamationSelonEtat(EtatReclamation etat);

    public int CalculNombreTotalReclamation();

    public List<Reclamation> FindByEtat(EtatReclamation etat);

    public Reclamation FindById(int id);

    public int DeleteReclamation();
    public void remove(Reclamation r);

    public int CalculNombreReclamationAsupprimer();
    public void edit(Reclamation r);

}
