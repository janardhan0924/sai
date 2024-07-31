package com.example.spring567.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring567.models.Dropdown;
import com.example.spring567.models.DropdownDto;
import com.example.spring567.services.DropdownRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/dropdown")

public class DropdownController {
	
	@Autowired
	 private DropdownRepository repo;
	
	@GetMapping({"","/"})
	public String showListPage(Model model) {
		List<Dropdown> dropdown=repo.findAll();
		model.addAttribute("dropdown", dropdown);
		return "Navbar/Dropdown";
	}
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		DropdownDto dropdownDto = new DropdownDto();
		model.addAttribute("dropdownDto", dropdownDto);
		return "Navbar/CreateDropdown";
	}
	
	
	@PostMapping("/create")
	public String createDropdown(
			@Valid @ModelAttribute DropdownDto dropdownDto,
			BindingResult result
			) {
		
		 Dropdown dropdown = new Dropdown();
		 dropdown.setHome(dropdownDto.getHome());
		 dropdown.setAboutus(dropdownDto.getAboutus());
		 dropdown.setServices(dropdownDto.getServices());
		 dropdown.setContactus(dropdownDto.getContactus());
		 dropdown.setLogin(dropdownDto.getLogin());
		 dropdown.setLogout(dropdownDto.getLogout());
		 dropdown.setFeedback(dropdownDto.getFeedback());
		 
		    
		    repo.save(dropdown);
		    
		 return "redirect:/CreatDropdown";
	}
	
	

}
