package ua.service;

import java.util.List;

import ua.entity.Client;
import ua.form.ClientForm;

public interface ClientService {

	List<Client> findAll();

	void save(ClientForm form);

	void delete(int id);

	Client findOne(int id);

	ClientForm findOneAdressInited(int id);
	
	Client findOneNameInited(int id);
	
}
