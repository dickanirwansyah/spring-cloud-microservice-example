package com.dicka.servicekatalog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dicka.servicekatalog.entity.Katalog;
import com.dicka.servicekatalog.entity.KatalogKategori;
import com.dicka.servicekatalog.entity.Kategori;
import com.dicka.servicekatalog.feign.KategoriFeign;
import com.dicka.servicekatalog.model.KatalogResponse;
import com.dicka.servicekatalog.repo.KatalogRepository;

@Service
public class KatalogService {

	@Autowired
	private KatalogRepository katalogRepository;
	
	@Autowired
	private KategoriFeign kategoriFeign;
	
	public Kategori findKategori(String kategoriId) {
		return kategoriFeign.findKategoriId(kategoriId);
	}
	
	public List<KatalogKategori> getKatalogKategori() {
		List<KatalogKategori> katalogKategoris = new ArrayList<>();
		List<Katalog> katalogs = katalogRepository.findAll();
		//List<Kategori> kategoris = kategoriFeign.findAllKategori();
		
		for (Katalog katalog : katalogs) {
			KatalogKategori kk = new KatalogKategori();
			Kategori kategori = kategoriFeign
					.findKategoriId(katalog.getKategoriId());
			kk.setKatalogId(katalog.getKatalogId());
			kk.setNama(katalog.getNama());
			kk.setQty(katalog.getQty());
			kk.setHarga(katalog.getHarga());
			kk.setStatus(katalog.isStatus());
			kk.setKategori(kategori);
			katalogKategoris.add(kk);
		}
		return katalogKategoris;
	}
	
	public List<Katalog> findAllKatalog(){
		List<Katalog> katalogs = katalogRepository.findAll();
		final Map<String, String> mapKategori = findKategoriId();
		List<Katalog> katalogsKategori = katalogs.stream()
				.filter(k -> mapKategori.get(k.getKategoriId())!=null && 
				mapKategori.get(k.getKategoriId())!=null)
				.collect(Collectors.toList());
		return katalogsKategori;
	}
	
	private Map<String, String> findKategoriId(){
		Map<String, String> getKategori = new HashMap<>();
		List<Kategori> kategoris = kategoriFeign.findAllKategori();
		for (Kategori kategori : kategoris) {
			getKategori.put(kategori.getKategoriId(), kategori.getNama());
		}
		return getKategori;
	}
}
