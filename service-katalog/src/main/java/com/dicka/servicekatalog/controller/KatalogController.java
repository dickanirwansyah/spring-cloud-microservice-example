package com.dicka.servicekatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicka.servicekatalog.entity.Katalog;
import com.dicka.servicekatalog.entity.KatalogKategori;
import com.dicka.servicekatalog.entity.Kategori;
import com.dicka.servicekatalog.service.KatalogService;

@RestController
@RequestMapping(value = "/api/v1/katalog")
public class KatalogController {

	@Autowired
	private KatalogService katalogService;
	
	@GetMapping
	public List<KatalogKategori> findAll(){
		return katalogService.getKatalogKategori();
	}
	
	@GetMapping(value="/kategori/{kategoriId}")
	public Kategori findKategori(@PathVariable("kategoriId") String kategoriId) {
		return katalogService.findKategori(kategoriId);
	}

}
