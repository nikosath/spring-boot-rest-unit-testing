package net.nikosath.springbootrestunittest.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.nikosath.springbootrestunittest.business.FictionalCharacterService;
import net.nikosath.springbootrestunittest.model.FictionalCharacter;
import net.nikosath.springbootrestunittest.model.Gender;

@RestController
@RequestMapping("/fictional-characters")
public class FictionalCharacterControllerImpl {

	@Autowired
	FictionalCharacterService fictCharService;

	@GetMapping
	public List<FictionalCharacter> retrieveFictCharacters(
			@RequestParam(value = "orderby", defaultValue = "fictionalCharacterId")
			String orderBy,
			@RequestParam(value = "orderdirection", defaultValue = "asc") 
			String orderDirection,
			@RequestParam(value = "sizelimit", defaultValue = "10") 
			int sizeLimit
			) {
		return fictCharService.retrieveFictCharacters(orderBy, orderDirection, sizeLimit);
	}
	
	@GetMapping("/count")
	public long countFictCharacters(
			@RequestParam(value = "firstname", required = false)
			String firstName,
			@RequestParam(value = "lastname", required = false) 
			String lastName,
			@RequestParam(value = "gender", required = false) 
			Gender gender,
			@RequestParam(value = "birthdate", required = false)
			@DateTimeFormat(pattern="dd/MM/yyyy")
			LocalDate birthdate
			) {
		FictionalCharacter fChar = new FictionalCharacter(firstName, lastName, gender, birthdate);
		return fictCharService.countFictCharacters(fChar);
	}

}
