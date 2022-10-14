package com.example.phandinhnhatktpmtuan7.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.phandinhnhatktpmtuan7.entity.ChuyenBay;


@RestController
@RequestMapping("/chuyenbay")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChuyenBayController {
	
	String url = "http://localhost:6868";
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value = "/{maCB}")
	public ChuyenBay getChuyenBayById(@PathVariable String maCB) {
		
		ResponseEntity<ChuyenBay> result = restTemplate.getForEntity(url + "/chuyenbay/" + maCB, ChuyenBay.class);
		
		return result.getBody();
	}
	
	@GetMapping(value = {
            "", "/"
    })
	public ChuyenBay[] getListChuyenBay() {
		ResponseEntity<ChuyenBay[]> result = restTemplate.getForEntity(url + "/chuyenbay", ChuyenBay[].class);
		ChuyenBay[] dsChuyenBay = result.getBody();
		return dsChuyenBay;
	}

}
