package com.SpringBootApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringBootApplication.resource.VoterEntity;

public interface VotingRepo extends JpaRepository<VoterEntity, Integer> {
}
