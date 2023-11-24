package com.example.back.service;

import com.example.back.model.OpenBankingParticipant;
import com.example.back.repository.OpenBankingParticipantRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

@Service
public class OpenBankingService {

    @Autowired
    private OpenBankingParticipantRepository participantRepository;

    public void updateParticipants() {
        System.out.println("Iniciando atualizaçao");
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("https://data.directory.openbankingbrasil.org.br/participants", String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.getBody());

                for (JsonNode participantNode : rootNode) {
                    OpenBankingParticipant participant = new OpenBankingParticipant();
                    participant.setName(participantNode.path("OrganisationName").asText());
                    JsonNode authorizationServers = participantNode.path("AuthorisationServers");

                    if (authorizationServers.isArray() && authorizationServers.size() > 0) {
                        JsonNode firstAuthorizationServer = authorizationServers.get(0);
                    
                        participant.setLogoUrl(firstAuthorizationServer.path("CustomerFriendlyLogoUri").asText());
                    
                        JsonNode apiResources = firstAuthorizationServer.path("ApiResources");
                        if (apiResources.isArray() && apiResources.size() > 0) {
                            JsonNode firstApiResource = apiResources.get(0);
                            participant.setAuthorizationServerUrl(firstApiResource.path("ApiCertificationUri").asText());
                        } 
                    } 
                    Optional<OpenBankingParticipant> existingParticipant = Optional.empty();

                    if (participantRepository != null) {
                        existingParticipant = participantRepository.findByName(participant.getName());
                    }

                    if (existingParticipant.isPresent()) {
                        participant.setId(existingParticipant.get().getId());
                    }

                    participantRepository.save(participant);
                }
            } 
        } catch (IOException e) {
            System.out.println("Err");
        }
    }
}
