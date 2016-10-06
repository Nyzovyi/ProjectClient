package ua.service.implementation;

import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.MyUser;
import ua.entity.Role;
import ua.repository.MyUserRepository;
import ua.service.MyUserService;



@Service("userDetailsService")
public class MyUserServiceImpl implements MyUserService, UserDetailsService{

	@Autowired
	private MyUserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public MyUser findByLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public void save(MyUser user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
	}
	
	@PostConstruct
	public void saveAdmin(){
		MyUser user = repository.findOne(1);
		if(user==null){
			user = new MyUser();
			user.setRole(Role.ROLE_ADMIN);
			user.setPassword(encoder.encode("admin"));
			user.setLogin("admin");
			user.setId(1);
			repository.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		if(Pattern.matches("^[0-9]{1,8}$", login)){
			return repository.findOne(Integer.valueOf(login));
		}
		return repository.findByLogin(login);
	}

	@Override
	public MyUser findById(int id) {
		return repository.findOne(id);
	}

	public void setRepository(MyUserRepository repository) {
		this.repository = repository;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}
}