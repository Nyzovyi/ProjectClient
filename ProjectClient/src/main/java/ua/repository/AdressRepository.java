package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Adress;

public interface AdressRepository extends JpaRepository<Adress, Integer>{

	Adress findByNamberHouse(int namberHouse);

	Adress findByNamberHouse(String namberHouse);
	
	@Query("SELECT distinct c FROM Adress c LEFT JOIN FETCH c.street"
			+ " ai LEFT JOIN FETCH ai.city s LEFT JOIN FETCH s.region"
			+ " ci LEFT JOIN FETCH ci.country")
	List<Adress> findAll();
	

}
