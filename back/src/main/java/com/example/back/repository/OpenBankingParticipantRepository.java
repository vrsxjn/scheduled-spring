package com.example.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.model.OpenBankingParticipant;

public interface OpenBankingParticipantRepository extends JpaRepository<OpenBankingParticipant, Long> {

  Optional<OpenBankingParticipant> findByName(String name);
}
