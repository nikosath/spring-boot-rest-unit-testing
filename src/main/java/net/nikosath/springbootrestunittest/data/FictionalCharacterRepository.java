package net.nikosath.springbootrestunittest.data;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nikosath.springbootrestunittest.model.FictionalCharacter;

public interface FictionalCharacterRepository extends JpaRepository<FictionalCharacter, Long> {
	
}
