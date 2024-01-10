package com.SpringBootApplication.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Component;

@Component
public class DateValidatorUsingLocalDate implements DateValidator {
  @Override
  public boolean isValid(final String dateOfBirth) {
    try {
      LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }
}
