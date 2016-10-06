package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Name;


public interface NameRepository extends JpaRepository<Name, Integer>{

	Name findByName(String name);

}
