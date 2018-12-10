package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, String>{
	List<Etudiant> findByNom(String nom);
}
