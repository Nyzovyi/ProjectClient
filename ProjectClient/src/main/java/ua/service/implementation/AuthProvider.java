package ua.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ua.entity.MyUser;
import ua.repository.MyUserRepository;

//@Service
public class AuthProvider implements AuthenticationProvider{

	@Autowired
	private MyUserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		MyUser user = userRepo.findByLogin(authentication.getName());
		if(user==null) throw new InternalAuthenticationServiceException("not found");
		if(!bCrypt.matches(authentication.getCredentials().toString(), user.getPassword()))
			throw new BadCredentialsException("wrong password");
		return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class == authentication;
	}

}