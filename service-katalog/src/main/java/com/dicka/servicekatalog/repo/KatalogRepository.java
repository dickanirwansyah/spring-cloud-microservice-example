package com.dicka.servicekatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dicka.servicekatalog.entity.Katalog;

public interface KatalogRepository extends JpaRepository<Katalog, String>{

}
