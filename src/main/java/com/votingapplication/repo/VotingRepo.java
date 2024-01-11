package com.votingapplication.repo;

import com.votingapplication.resource.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepo extends JpaRepository<VoterEntity, Integer> {
}
