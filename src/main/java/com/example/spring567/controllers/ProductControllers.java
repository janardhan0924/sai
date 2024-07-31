package com.example.spring567.controllers; 

import java.io.InputStream;
import java.nio.file.*;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring567.models.ProductDto;
import com.example.spring567.models.Navbar;
import com.example.spring567.models.Product;
import com.example.spring567.services.NavbarRepository;
import com.example.spring567.services.ProductRepository;


import jakarta.validation.Valid;


@Controller

@RequestMapping("/products")
public class ProductControllers {
	
	
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private NavbarRepository navRepo;
	
	@GetMapping({"","/"})
	public String showProductList(Model model) {
		List<Product> products=repo.findAll();
	    model.addAttribute("products", products);
		return "product/index";
	}
	
	@GetMapping({"/cards"})
	public String Card(Model model) {
		List<Product> products = repo.findAll();
		model.addAttribute("products", products);
		return "product/Cards";
	}
	
	@GetMapping({"/carousel"})
	public String Carousel(Model model) {
		List<Product> products = repo.findAll();
		model.addAttribute("products", products);
		return "product/Carousel";
	}
	
	@GetMapping({"/navbarcarousel"})
	public String Website(Model model) {
		List<Product> products = repo.findAll();
		model.addAttribute("products", products);
		List<Navbar> navbar = navRepo.findAll();
		model.addAttribute("navbar", navbar);
		return "product/navbarcarousel";
	}
	
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		ProductDto productDto = new ProductDto();
		model.addAttribute("productDto",productDto);
		return "product/CreateProduct";
	}
	
	@PostMapping("/create")
	public String createProduct(
			@Valid @ModelAttribute ProductDto productDto,
			BindingResult result
			) {
		if(productDto.getImageFile().isEmpty()) {
			result.addError(new FieldError("productDto","imageFile","The image file is required"));
		}
		
		if(result.hasErrors()) {
			return "product/CreateProduct";
		}
		
		
		MultipartFile image = productDto.getImageFile();
		    Date createdAt = new Date();
		    String storageFileName = createdAt.getTime()+"_"+image.getOriginalFilename();
		    
		    try{
		    	String uploadDir = "public/images/";
		    	Path uploadpath=Paths.get(uploadDir);
//		       Path uploadPath = Paths.get(uploadDir);
		    	
		    	if(!Files.exists(uploadpath)) {
		    		Files.createDirectories(uploadpath);
		    	}
		    	
		    	
		    	try(InputStream inputStream = image.getInputStream()){
		    		Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
		    		        StandardCopyOption.REPLACE_EXISTING);
		    	}
		    }catch(Exception ex) {
		    	System.out.println("Exception :" + ex.getMessage());
		    }
		    
		    
		    Product product = new Product();
		    product.setName(productDto.getName());
		    product.setBrand(productDto.getBrand());
		    product.setCategory(productDto.getCategory());
		    product.setPrice(productDto.getPrice());
		    product.setDescription(productDto.getDescription());
		    product.setCreateAt(createdAt);
		    product.setImageFileName(storageFileName);
		    
		    repo.save(product);
		    
		 return "redirect:/products";
	}
	
	
	@GetMapping("/edit") 
		public String showEditPage(
				Model model,
				@RequestParam int id
				) {
		try {
			Product product = repo.findById(id).get();
			model.addAttribute("product",product);
			
			ProductDto productDto = new ProductDto();
			productDto.setName(product.getName());
			productDto.setBrand(product.getBrand());
			productDto.setCategory(product.getCategory());
			productDto.setPrice(product.getPrice());
			productDto.setDescription(product.getDescription());
			
			model.addAttribute("productDto",productDto);
		}	
		catch(Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/products";
	
		
	}	
		return "product/EditProduct";

		
 }
	
	@PostMapping("/edit")
	public String updateProduct(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute ProductDto productDto,
			BindingResult result
			) {
		try {
			Product product = repo.findById(id).get();
			model.addAttribute("product", product);
			
			if(result.hasErrors()) {
				return "product/EditProduct";
			}
			
			if(!productDto.getImageFile().isEmpty()) {
				//for deleting the old images
				String uploadDir ="public/images/";
				Path oldImagePath = Paths.get(uploadDir +product.getImageFileName());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception ex) {
					System.out.println("Exception:" +ex.getMessage());
				}
				//save the new image
				MultipartFile image = productDto.getImageFile();
				Date createdAt = new Date();
				String storageFileName = createdAt.getTime()+"_"+image.getOriginalFilename();
				
				try(InputStream inputStream = image.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
					        StandardCopyOption.REPLACE_EXISTING);
				}
				  product.setImageFileName(storageFileName);
			}
			 
			 product.setName(productDto.getName());
			 product.setBrand(productDto.getBrand());
			 product.setCategory(productDto.getCategory());
			 product.setPrice(productDto.getPrice());
			 product.setDescription(productDto.getDescription());
			 
			 repo.save(product);
			
		}
		catch(Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
		
		return "redirect:/products";
		
	}
	
	@GetMapping("/delete")
	public String deleteProduct(
			@RequestParam int id
			) {
		try {
			Product product = repo.findById(id).get();
			
			Path imagePath = Paths.get("public/images/" + product.getImageFileName());
			
			try {
				Files.delete(imagePath);
			}
			catch(Exception ex) {
				System.out.println("Exception:" + ex.getMessage());
			}
			repo.delete(product);
		}
		catch(Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
		return "redirect:/products";
	}
	
	
 
}
