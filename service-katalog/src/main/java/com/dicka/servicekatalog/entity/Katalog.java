package com.dicka.servicekatalog.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Katalog implements Serializable {

	@Id
	private String katalogId;
	private String nama;
	private int harga;
	private int qty;
	private boolean status;
	private String kategoriId;
	
	@Transient
	Kategori kategori;
	
	public Katalog() {
		
	}
	
	public Katalog(String katalogId, String nama, int harga, int qty, boolean status, String katagoriId) {
		this.katalogId = katalogId;
		this.nama = nama;
		this.harga = harga;
		this.qty = qty;
		this.status = status;
		this.kategoriId = katagoriId;
	}
	
	public String getKatalogId() {
		return katalogId;
	}
	
	public void setKatalogId(String katalogId) {
		this.katalogId = katalogId;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public int getHarga() {
		return harga;
	}
	
	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getKategoriId() {
		return kategoriId;
	}
	
	public void setKategoriId(String kategoriId) {
		this.katalogId = kategoriId;
	}
	
	public Kategori getKategori() {
		return kategori;
	}
	
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}
}
