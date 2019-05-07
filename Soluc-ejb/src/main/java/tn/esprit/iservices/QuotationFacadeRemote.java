/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.iservices;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.entities.Quotation;

/**
 *
 * @author ksamih
 */
@Remote
public interface QuotationFacadeRemote {

    void create(Quotation quotation);

    void edit(Quotation quotation);

    void remove(Quotation quotation);

    Quotation find(Object id);

    List<Quotation> findAll();

    List<Quotation> findRange(int[] range);

    int count();
    
}
