package com.example.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "open_banking_participant")
public class OpenBankingParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String logoUrl;
    private String authorizationServerUrl;

    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getLogoUrl() {
      return logoUrl;
    }
    public void setLogoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
    }
    public String getAuthorizationServerUrl() {
      return authorizationServerUrl;
    }
    public void setAuthorizationServerUrl(String authorizationServerUrl) {
      this.authorizationServerUrl = authorizationServerUrl;
    }

    
}
