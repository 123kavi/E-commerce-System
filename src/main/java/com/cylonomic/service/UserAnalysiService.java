package com.cylonomic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cylonomic.domain.UserAnalysi;
import com.cylonomic.repository.UserAnalysiRepository;


@Service
public class UserAnalysiService {
	
	@Autowired
	private UserAnalysiRepository repository;
	
	public String saveUserAnalysi(UserAnalysi userAnalysi)
	{
		repository.save(userAnalysi);
		return "saved UserAnalysi Resource";
	}
	
	public List<UserAnalysi> getAllUserAnalysi()
	{
		return repository.findAll();
	}

}
