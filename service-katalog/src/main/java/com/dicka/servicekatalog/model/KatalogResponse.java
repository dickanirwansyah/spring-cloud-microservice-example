package com.dicka.servicekatalog.model;

import com.dicka.servicekatalog.entity.Kategori;

public class KatalogResponse {

	private String katalogId;
	private String nama;
	private int harga;
	private int qty;
	private boolean status;
	private Kategori kategori;
	
	public KatalogResponse() {
		
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
	public Kategori getKategori() {
		return kategori;
	}
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}
	
	
}
