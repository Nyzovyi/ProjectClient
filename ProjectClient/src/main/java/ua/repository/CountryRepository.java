package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

	Country findByName(String name);
	
	
//	default void delete(String name){
//		delete(findByName(name));
//	}
//	
//	@Modifying
//	@Query("DELETE FROM Country c WHERE c.name=:name")
//	void deleteByName(@Param("name") String name);
}
