package tn.esprit.iservices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Forum;

@Remote
public interface ForumFacadeRemote {

	void create(Forum forum);

    void edit(Forum forum);

    void remove(Forum forum);

    Forum find(Forum forum);

    List<Forum> findAll();
	
}
