package net.nikosath.springbootrestunittest.business;

import java.util.List;

import net.nikosath.springbootrestunittest.model.FictionalCharacter;

public interface FictionalCharacterService {

	List<FictionalCharacter> retrieveFictCharacters(String orderBy, String orderDirection, int sizeLimit);

	long countFictCharacters(FictionalCharacter fChar);

}