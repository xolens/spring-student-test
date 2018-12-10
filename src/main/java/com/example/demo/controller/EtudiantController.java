package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Etudiant;
import com.example.demo.repository.EtudiantRepository;

@Controller
@RequestMapping(path = "/")
public class EtudiantController {
	@Autowired
	EtudiantRepository etudiantRepository;
	public static final Optional<Etudiant> nullEtudiant = Optional.empty();
	
	
	@GetMapping(path="/login")
	public String login() {
		return "login.html";
	}

	/*
	 * Liste de tous les etudiants
	 */
	@GetMapping(path="/")
	public String listeEtudiant(Model model) {
		ArrayList<Etudiant> etudiants = new ArrayList<>();
		etudiantRepository.findAll().forEach(etudiants::add);
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("oldMatricule", "");
		model.addAttribute("etudiant", nullEtudiant);
		return "student_list.html";
	}

	/*
	 * Donnees de l'etudiant correspondant au matricule
	 */
	@GetMapping(path="/{matricule}")
	public String getEtudiant(@PathVariable(value="matricule") String matricule, Model model) {
		model.addAttribute("oldMatricule", matricule);
		model.addAttribute("etudiant", etudiantRepository.findById(matricule));
		return "student_form.html";
	}
	
	/*
	 * Mise à jour d'un etudiant à partir de son matricule
	 */
	@PostMapping(path="/")
	public String setEtudiant(  @RequestParam(value = "oldMatricule", required = false) String oldMatricule,
												@ModelAttribute Etudiant etudiant) {
		Optional<Etudiant> oldEtudiant = etudiantRepository.findById(oldMatricule);
		if(oldEtudiant.isPresent()) {
			etudiantRepository.deleteById(oldMatricule);
		}
		etudiantRepository.save(etudiant);
		return "redirect:/";
	}
	
	/*
	 * Suppression d'un etudiant à partir de son matricule
	 */
	@PostMapping(path="/delete")
	public String suppressionEtudiant(@RequestParam String matricule, Model model) {
		etudiantRepository.deleteById(matricule);
		return "redirect:/student";
	}
}
