package com.example.training;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")

public class LocationsController {
	
	@Autowired
	private LocationsRepository locationsRepo;
	
	@GetMapping("/locations")
	public List <Locations> getAllLocations(){
		return locationsRepo.findAll();
		}
	
	@GetMapping("/locations/{id}")
	public Optional <Locations> getLocationsById(@PathVariable String id){
		return locationsRepo.findById(id);
	}
	
	@PostMapping("/locations")
	public Locations saveRegions(@RequestBody Locations locations) {
		return locationsRepo.save(locations);
	}
	
	@PutMapping("/locations/{id}")
	public Locations update(@PathVariable String id,@Validated @RequestBody Locations locations) {
		locations.setId(id);
		return locationsRepo.save(locations);
	}
	
	@DeleteMapping("/locations/{id}")
	public void deletelocations(@PathVariable String id) {
		locationsRepo.deleteById(id);
	}


}
