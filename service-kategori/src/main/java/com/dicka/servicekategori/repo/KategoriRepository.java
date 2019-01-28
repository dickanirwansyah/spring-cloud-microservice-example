package com.dicka.servicekategori.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dicka.servicekategori.entity.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, String>{

	Kategori findByKategoriId(String kategoriId);
	
}
