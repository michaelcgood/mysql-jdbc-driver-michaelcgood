package com.michaelcgood.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michaelcgood.model.SystemExample;

@Repository
public interface SystemRepository extends CrudRepository<SystemExample,Long> {
	

}
