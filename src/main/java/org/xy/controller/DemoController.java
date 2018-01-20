package org.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xy.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private DemoService demoService;
	
	@GetMapping("/getName/{id}")
	@ResponseBody
	public String getName(@PathVariable("id") Integer id) throws Exception {
		return demoService.getName(id);
	}
	
}
