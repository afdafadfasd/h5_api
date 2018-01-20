package org.xy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xy.dao.DemoDao;

@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private DemoDao demoDao;
	
	public String getName(int id)  throws Exception{
		return demoDao.getName(id);
	}
	
}
