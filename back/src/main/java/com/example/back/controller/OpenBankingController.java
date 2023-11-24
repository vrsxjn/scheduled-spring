package com.example.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.model.OpenBankingParticipant;
import com.example.back.repository.OpenBankingParticipantRepository;
import com.example.back.service.OpenBankingService;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin("*")
public class OpenBankingController {
    @Autowired
    private OpenBankingParticipantRepository participantRepository;

    @Autowired
    private OpenBankingService openBankingService;

    @GetMapping
    public List<OpenBankingParticipant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Scheduled(fixedRate = 60000)
    public void updateParticipants() {
        openBankingService.updateParticipants();
    }

  }