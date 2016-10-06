package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{

	@Query("SELECT r FROM Region r LEFT JOIN FETCH r.country WHERE r.id=:id")
	Region findOneCountryInited(@Param("id")int id);

	Region findByName(String name);
	
}
