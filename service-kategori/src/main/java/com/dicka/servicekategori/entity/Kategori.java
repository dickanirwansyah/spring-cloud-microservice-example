package com.dicka.servicekategori.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kategori implements Serializable{

	@Id
	private String kategoriId;
	private String nama;
	
	public Kategori(String kategoriId, String nama) {
		this.kategoriId = kategoriId;
		this.nama = nama;
	}
	
	public Kategori() {
		
	}
	

	public String getKategoriId() {
		return kategoriId;
	}
	
	public void setKategoriId(String kategoriId) {
		this.kategoriId = kategoriId;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
}
