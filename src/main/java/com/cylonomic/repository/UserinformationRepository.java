package com.cylonomic.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.cylonomic.domain.Userinformation;

public interface UserinformationRepository extends JpaRepository<Userinformation, Long>, JpaSpecificationExecutor<Userinformation> {
	
	@EntityGraph(attributePaths = { "provinces", "categories", "brands"/*, "mails" */})
	List<Userinformation> findAllEagerBy();	
		
	@EntityGraph(attributePaths = { "provinces", "categories", "brands"/*, "mails" */})
	Optional<Userinformation> findById(Long id);

	
	@Query("SELECT DISTINCT c.name FROM Category c")
	List<String> findAllCategories();
	
	@Query("SELECT DISTINCT b.name FROM Brand b")
	List<String> findAllBrands();
	
	
	//@Query("SELECT DISTINCT m.name FROM CusMail m")
	//List<String> findAllMails();

	
	
	@Query("SELECT DISTINCT s.name FROM Category s")
	
	List<String> findAllProvinces();


	
}
