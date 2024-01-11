package com.votingapplication.resource;

import com.votingapplication.dto.VoterDto;
import com.votingapplication.service.VotingService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
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

@RestController
@Validated
public class VotingResource {
  @Autowired
  private DateValidatorUsingLocalDate dateValidatorUsingLocalDate;
  @Autowired
  private VotingService votingService;

  @PostMapping("voters")
  public ResponseEntity<?> addVoters(
      final @Valid @RequestBody VoterDto voterDto) {
    if (!dateValidatorUsingLocalDate.isValid(voterDto.getDateOfBirth())) {
      return new ResponseEntity<>(
     "Invalid date of birth", HttpStatus.BAD_REQUEST);
    }
    votingService.addVoter(voterDto);
    return new ResponseEntity<>(null, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
      final MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<String, String>();
    ex.getBindingResult()
        .getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        });
    return errors;
  }
}
