package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer>{

	MyUser findByLogin(String login);
}
