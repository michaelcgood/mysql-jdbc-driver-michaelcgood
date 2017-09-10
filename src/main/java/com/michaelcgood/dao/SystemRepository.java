package com.michaelcgood.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michaelcgood.model.System;

@Repository
public interface SystemRepository extends CrudRepository<System,Long> {
	

}
