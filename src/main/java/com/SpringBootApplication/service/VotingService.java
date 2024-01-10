package com.SpringBootApplication.service;

import com.SpringBootApplication.repo.VotingRepo;
import com.SpringBootApplication.resource.VoterDto;
import com.SpringBootApplication.resource.VoterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VotingService {
  @Autowired
  private VotingRepo votingRepo;
  @Autowired
  private ModelMapper modelMapper;

  public void addVoter(final VoterDto voterDto) {
    // convert DTO to entity
    VoterEntity postRequest = modelMapper.map(voterDto, VoterEntity.class);
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    String encryptedPwd = bcrypt.encode(postRequest.getPassword());
    System.out.println(encryptedPwd);
    postRequest.setPassword(encryptedPwd);
    votingRepo.save(postRequest);
  }
}
