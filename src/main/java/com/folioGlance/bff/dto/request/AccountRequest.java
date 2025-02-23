package com.folioGlance.bff.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class AccountRequest {

  @JsonProperty(value = "email" , required = true)
  @NotBlank(message = "Email is required")
  private String email ;

  @JsonProperty(value = "password" , required = true)
  @NotBlank(message = "Password is required")
  private String password;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setEmail(String email){
    this.email=email;
  }

  public void setPassword(String password){
    this.password=password;
  }
}
