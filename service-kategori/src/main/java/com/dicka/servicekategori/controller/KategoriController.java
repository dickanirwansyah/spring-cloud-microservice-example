package com.dicka.servicekategori.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicka.servicekategori.entity.Kategori;
import com.dicka.servicekategori.repo.KategoriRepository;

@RestController
@RequestMapping(value = "/api/v1/service-kategori")
public class KategoriController {

	@Autowired
	private KategoriRepository kategoriRepository;
	
	@GetMapping()
	public ResponseEntity<List<Kategori>> getAll(){
		List<Kategori> kategoris = new ArrayList<>();
		for (Kategori k : kategoriRepository.findAll()) {
			kategoris.add(k);
		}
		
		if (kategoris.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Kategori>>(kategoris, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{kategoriId}")
	public ResponseEntity<Optional<Kategori>> getId(@PathVariable("kategoriId") String kategoriId){
		Optional<Kategori> kategori = kategoriRepository.findById(kategoriId);
		
		if(!kategori.isPresent()) {
			return new ResponseEntity<Optional<Kategori>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Optional<Kategori>>(kategori, HttpStatus.OK);
	}
	
	@GetMapping(value = "/by/{kategoriId}")
	public ResponseEntity<Kategori> findKategoriId(@PathVariable("kategoriId")String kategoriId){
		Kategori kategori = kategoriRepository.findByKategoriId(kategoriId);
		
		if(kategori == null) {
			return new ResponseEntity<Kategori>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Kategori>(kategori, HttpStatus.OK);
	}
}
