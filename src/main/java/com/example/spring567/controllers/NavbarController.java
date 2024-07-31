package com.example.spring567.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring567.models.Dropdown;
import com.example.spring567.models.Navbar;
import com.example.spring567.models.NavbarDto;
import com.example.spring567.models.Product;
import com.example.spring567.services.DropdownRepository;
import com.example.spring567.services.NavbarRepository;
import com.example.spring567.services.ProductRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/navbar")

public class NavbarController {
	
	@Autowired
	 private NavbarRepository repo;
	
	@Autowired
	private ProductRepository Prepo;
	
	@Autowired
	 private DropdownRepository drepo;
	
	
	
	
	@GetMapping({"","/"})
	public String showListPage(Model model) {
		
		List<Navbar> navbar=repo.findAll();
		model.addAttribute("navbar", navbar);
		return "navbar/home";
	}
	
	
	@GetMapping("/navbar")
	public String showNavbar(Model model) {
		List<Navbar> navbar=repo.findAll();
		model.addAttribute("navbar", navbar);
		return "navbar/navbar";
	}
	
	@GetMapping("/navbarcarousel")
	public String Website(Model model) {
		List<Product> products = Prepo.findAll();
		model.addAttribute("products", products);
		List<Dropdown> dropdown=drepo.findAll();
		model.addAttribute("dropdown", dropdown);
		List<Navbar> navbar = repo.findAll();
		model.addAttribute("navbar", navbar);
		return "product/Navbar";
	}
	
	
	
	@GetMapping({"/cards"})
	public String Card(Model model) {
		List<Navbar> navbar = repo.findAll();
		model.addAttribute("navbar", navbar);
		return "navbar/cards";
	}
	
	
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		NavbarDto navbarDto = new NavbarDto();
		model.addAttribute("navbarDto", navbarDto);
		return "navbar/CreateNavbar";
	}
	
	@PostMapping("/create")
	public String createNavbar(
			@Valid @ModelAttribute NavbarDto navbarDto,
			BindingResult result
			) {
		
		 Navbar navbar = new Navbar();
		 navbar.setHeading1(navbarDto.getHeading1());
		 navbar.setHeading2(navbarDto.getHeading2());
		 navbar.setHeading3(navbarDto.getHeading3());
		 navbar.setHeading4(navbarDto.getHeading4());
		 navbar.setHeading5(navbarDto.getHeading5());
		 navbar.setHeading6(navbarDto.getHeading6());
		 navbar.setHeading7(navbarDto.getHeading7());
		 
		    
		    repo.save(navbar);
		    
		 return "redirect:/navbar";
	}
	
	@GetMapping("/edit")
	public String showEditPage(
			Model model,
			@RequestParam int id) {
		
		try {
			Navbar navbar = repo.findById(id).get();
			model.addAttribute("navbar",navbar);
			
			NavbarDto navbarDto = new NavbarDto();
			navbarDto.setHeading1(navbar.getHeading1());
			navbarDto.setHeading2(navbar.getHeading2());
			navbarDto.setHeading3(navbar.getHeading3());
			navbarDto.setHeading4(navbar.getHeading4());
			navbarDto.setHeading5(navbar.getHeading5());
			navbarDto.setHeading6(navbar.getHeading6());
			navbarDto.setHeading7(navbar.getHeading7());
			
			model.addAttribute("navbarDto",navbarDto);
		}	
		catch(Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/navbar";
	
		
	}	
		return "navbar/EditNavbar";

		
	}
	
	@PostMapping("/edit")
	public String editNavbar(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute NavbarDto navbarDto,
			BindingResult result) {
		try {
			Navbar navbar = repo.findById(id).get();
			model.addAttribute("navbar", navbar);
			
			if(result.hasErrors()) {
				return "navbar/EditNavbar";
		}
			
			
			 
			 navbar.setHeading1(navbarDto.getHeading1());
			 navbar.setHeading2(navbarDto.getHeading2());
			 navbar.setHeading3(navbarDto.getHeading3());
			 navbar.setHeading4(navbarDto.getHeading4());
			 navbar.setHeading5(navbarDto.getHeading5());
			 navbar.setHeading6(navbarDto.getHeading6());
			 navbar.setHeading7(navbarDto.getHeading7());
			 
			 repo.save(navbar);
	}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return "redirect:/navbar";
	
}	
	
	@GetMapping("/delete")
	public String deleteNavbar(
			@RequestParam int id
			) {
		
			Navbar navbar = repo.findById(id).get();
		
			
		repo.delete(navbar);
		
		
	
		return "redirect:/navbar";
	
	
	}		
	

}
