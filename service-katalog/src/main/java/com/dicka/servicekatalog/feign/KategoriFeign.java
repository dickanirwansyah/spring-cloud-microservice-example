package com.dicka.servicekatalog.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dicka.servicekatalog.entity.Kategori;

@FeignClient(name = "service-kategori")
public interface KategoriFeign {

	@GetMapping(value = "/api/v1/service-kategori")
	List<Kategori> findAllKategori();
	
	@GetMapping(value = "/api/v1/service-kategori/by/{kategoriId}")
	Kategori findKategoriId(@PathVariable("kategoriId") String kategoriId);
}
