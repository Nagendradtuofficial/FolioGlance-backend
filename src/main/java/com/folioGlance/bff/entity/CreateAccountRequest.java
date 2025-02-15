package com.folioGlance.bff.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class CreateAccountRequest {

  @JsonProperty(value = "email" , required = true)
  @NotBlank(message = "Email is required")
  String email ;

  @JsonProperty(value = "password" , required = true)
  @NotBlank(message = "Password is required")
  String password;

  @JsonProperty(value = "uuid" , required = false)
  String uuid;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getUuid() {
    return uuid;
  }

  public void setEmail(String email){
    this.email=email;
  }

  public void setPassword(String password){
    this.password=password;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
