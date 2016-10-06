package ua.service.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Client;
import ua.form.ClientForm;
import ua.repository.ClientRepository;
import ua.service.ClientService;




@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public void save(ClientForm form) {
		Client client = new Client();
		client.setId(form.getId());
		client.setAdress(form.getAdress());
		client.setName(form.getName());
		client.setPath(form.getPath());
		client.setVersion(form.getVersion());
		clientRepository.saveAndFlush(client);
		if(form.getFile()!=null&&!form.getFile().isEmpty()){
			int index = form.getFile().getOriginalFilename().lastIndexOf(".");
			String extension = form.getFile().getOriginalFilename()
					.substring(index);
			String path = System.getProperty("catalina.home")+"/images/client/";
			File file = new File(path);
			if(!file.exists())file.mkdirs();
			file = new File(file, client.getId()+extension);
			try {
				form.getFile().transferTo(file);
				client.setPath(extension);
				client.setVersion(form.getVersion()+1);
			} catch (IllegalStateException | IOException e) {
			}
			clientRepository.save(client);
		}
	}

	@Override
		public ClientForm findOneAdressInited(int id) {
		Client client = clientRepository.findOneAdressInited(id);
		ClientForm form = new ClientForm();
		form.setAdress(client.getAdress());
		form.setId(client.getId());
		form.setName(client.getName());
		form.setPath(client.getPath());
		form.setVersion(client.getVersion());
		return form;
	}

	@Override
	public void delete(int id) {
		clientRepository.delete(id);
	}

	@Override
	public Client findOne(int id) {
		return clientRepository.findOne(id);
	}

	@Override
	public Client findOneNameInited(int id) {
		return clientRepository.findOneNameInited(id);
	}

	
}
