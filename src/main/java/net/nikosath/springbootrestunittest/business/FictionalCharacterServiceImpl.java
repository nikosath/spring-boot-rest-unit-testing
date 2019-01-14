package net.nikosath.springbootrestunittest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import net.nikosath.springbootrestunittest.data.FictionalCharacterRepository;
import net.nikosath.springbootrestunittest.model.FictionalCharacter;

@Component
public class FictionalCharacterServiceImpl implements FictionalCharacterService {

	@Autowired
	FictionalCharacterRepository fictCharRepo;
	
	/* (non-Javadoc)
	 * @see net.nikosath.springbootrestunittest.business.FictionalCharacterService#retrieveFictCharacters(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<FictionalCharacter> retrieveFictCharacters(String orderBy, String orderDirection, int sizeLimit) {
		Sort sort = Sort.by(Direction.fromString(orderDirection), orderBy);
		PageRequest request = PageRequest.of(0, sizeLimit, sort);
		Page<FictionalCharacter> findAll = fictCharRepo.findAll(request);
		return findAll.getContent();
	}
	
	/* (non-Javadoc)
	 * @see net.nikosath.springbootrestunittest.business.FictionalCharacterService#countFictCharacters(net.nikosath.springbootrestunittest.model.FictionalCharacter)
	 */
	@Override
	public long countFictCharacters(FictionalCharacter fChar) {
		return fictCharRepo.count(Example.of(fChar));
	}
	
}
