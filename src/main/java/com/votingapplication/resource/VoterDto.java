package com.votingapplication.resource;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class VoterDto {
  @NotBlank(message = "First Name is mandatory")
  private String firstname;

  private String middlename;

  @NotBlank(message = "Last Name is mandatory")
  private String lastname;

  @NotBlank(message = "Date of Birth is mandatory")
  private String dateOfBirth;

  @Email(message = "Email is not valid",
      regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
  @NotBlank(message = "Email cannot be empty")
  private String email;

  @NotBlank(message = "Password cannot be empty")
  private String password;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(final String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(final String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "VoterModel [firstname=" + firstname + ", "
      + "middlename=" + middlename + ", lastname="
      + lastname + ", dateOfBirth=" + dateOfBirth + ", "
      + "email=" + email + ", password=" + password + "]";
  }
}
