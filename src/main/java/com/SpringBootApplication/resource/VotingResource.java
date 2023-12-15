package com.SpringBootApplication.resource;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBootApplication.repo.VotingRepo;

@RestController
@Validated
public class VotingResource {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	DateValidatorUsingLocalDate dateValidatorUsingLocalDate;
	@Autowired
	VotingRepo votingrepo;

	@PostMapping("voters")
	public ResponseEntity<?> addVoters(@Valid @RequestBody VoterDto voterDto) {
		if (!dateValidatorUsingLocalDate.isValid(voterDto.getDateOfBirth())) {
			return new ResponseEntity<>("Invalid date of birth", HttpStatus.BAD_REQUEST);
		}
		// convert DTO to entity
		VoterEntity postRequest = modelMapper.map(voterDto, VoterEntity.class);
		VoterEntity post=votingrepo.save(postRequest);
		// entity to DTO
		VoterDto postResponse = modelMapper.map(post, VoterDto.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
