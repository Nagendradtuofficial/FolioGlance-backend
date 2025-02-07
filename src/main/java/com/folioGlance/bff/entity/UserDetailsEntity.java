package com.folioGlance.bff.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailsEntity {

  @JsonProperty(value = "email" , required = false)
  String emailId ;

  @JsonProperty(value = "password" , required = false)
  String password;

  @JsonProperty(value = "uuid" , required = false)
  String uuid;

  public String getEmailId() {
    return emailId;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
