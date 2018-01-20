package org.xy.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao {
	
	String getName(int id) throws Exception;
	
}
