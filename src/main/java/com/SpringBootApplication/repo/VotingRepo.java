package com.SpringBootApplication.repo;

import com.SpringBootApplication.resource.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepo extends JpaRepository<VoterEntity, Integer> {
}
