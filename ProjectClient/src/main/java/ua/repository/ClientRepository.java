package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{


	@Query("SELECT r FROM Client r LEFT JOIN FETCH r.name "
			+ "WHERE r.id=:id")
	Client findOneNameInited(@Param("id") int id);
	
	@Query("SELECT distinct c FROM Client c LEFT JOIN FETCH c.adress"
			+ " ai LEFT JOIN FETCH ai.street s LEFT JOIN FETCH s.city"
			+ " ci LEFT JOIN FETCH ci.region r LEFT JOIN FETCH r.country"
			+ " where c.id=:id")
	Client findOneAdressInited(@Param("id") int id);
}
