/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.iservices;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReponseReclamation;

/**
 *
 * @author ksamih
 */
@Remote
public interface ReponseReclamationFacadeRemote {

    public int AddReponse(ReponseReclamation reponse);

    public int RemoveReponse(ReponseReclamation reponse);

    public List<ReponseReclamation> FindReponseByidReclamation(int id);

    public int CalculTotalReponse(int idReclamation);
    
    public ReponseReclamation getResponse(Reclamation rec);
    
    public void edit(ReponseReclamation reponseReclamation);

}
