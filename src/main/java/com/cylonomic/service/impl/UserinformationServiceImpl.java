package com.cylonomic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cylonomic.domain.Userinformation;
import com.cylonomic.repository.UserinformationRepository;
import com.cylonomic.repository.UserinformationSpecification;
import com.cylonomic.service.UserinformationService;

@Service
@Transactional
public class UserinformationServiceImpl implements UserinformationService {

	@Autowired
	private UserinformationRepository userinformationRepository;
	
	@Value("${articleservice.featured-items-number}")
	private int featuredUserinformationsNumber;

	@Override
	public List<Userinformation> findAllUserinformations() {
		return (List<Userinformation>) userinformationRepository.findAllEagerBy();
	}
	
	@Override
	public Page<Userinformation> findUserinformationsByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, 
										List<String> provinces, List<String> categories, List<String> brands/*, List<String> mails*/, String search) {		
		Page<Userinformation> page = userinformationRepository.findAll(UserinformationSpecification.filterBy(priceLow, priceHigh, provinces, categories, brands,/*mails*/search), pageable);
        return page;		
	}	
	
	@Override
	public List<Userinformation> findFirstUserinformations() {
		return userinformationRepository.findAll(PageRequest.of(0,featuredUserinformationsNumber)).getContent(); 
	}

	@Override
	public Userinformation findUserinformationById(Long id) {
		Optional<Userinformation> opt = userinformationRepository.findById(id);
		return opt.get();
	}

	@Override
	@CacheEvict(value = { "provinces", "categories", "brands" /*,"mails"*/}, allEntries = true)
	public Userinformation saveUserinformation(Userinformation userinformation) {
		return userinformationRepository.save(userinformation);
	}
	
	@Override
	@CacheEvict(value = { "provinces", "categories", "brands"/*,"mails"*/ }, allEntries = true)
	public void deleteUserinformationById(Long id) {
		userinformationRepository.deleteById(id);		
	}

	
	@Override
	@Cacheable("provinces")
	public List<String> getAllProvinces() {
		return userinformationRepository.findAllProvinces();
	}

	@Override
	@Cacheable("categories")
	public List<String> getAllCategories() {
		return userinformationRepository.findAllCategories();
	}

	@Override
	@Cacheable("brands")
	public List<String> getAllBrands() {
		return userinformationRepository.findAllBrands();
	}
	//@Override
	//@Cacheable("mails")
	///public List<String> getAllMails() {
	//	return articleRepository.findAllMails();
	//}








}
