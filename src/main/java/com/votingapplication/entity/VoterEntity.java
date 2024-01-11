package com.votingapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VoterEntity {
  @Id
  @GeneratedValue
  private int voterid;

  private String firstname;

  private String middlename;

  private String lastname;

  private String dateOfBirth;

  private String email;

  private String password;

  public int getVoterid() {
    return voterid;
  }

  public void setVoterid(final int voterid) {
    this.voterid = voterid;
  }

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
    return "VoterModel [firstname=" + firstname + ", middlename=" + middlename
      + "lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", "
        + "email=" + email + ", password=" + password + "]";
  }
}
