package com.SpringBootApplication.resource;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VoterDto {
  @NotBlank(message = "Name is mandatory")
  private String firstname;

  @NotNull(message = "Name cannot be null")
  private String middlename;

  @NotBlank(message = "LastName is mandatory")
  private String lastname;

  @NotBlank(message = "Date of birth is mandatory")
  private String dateOfBirth;

  @Email(message = "Email is not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
  @NotBlank(message = "Email cannot be empty")
  private String email;

  @NotBlank(message = "Password cannot be empty")
  private String password;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "VoterModel [firstname="
        + firstname
        + ", middlename="
        + middlename
        + ", lastname="
        + lastname
        + ", dateOfBirth="
        + dateOfBirth
        + ", email="
        + email
        + ", password="
        + password
        + "]";
  }
}
