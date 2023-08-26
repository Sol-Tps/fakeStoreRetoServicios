package com.fakestoreapi.models.responseDelete;

import com.fakestoreapi.models.Address;
import com.fakestoreapi.models.Name;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelDelete {
    @JsonProperty("address")
    public Address address;

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("email")
    public String email;

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    @JsonProperty("name")
    public Name name;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("v")
    public Integer v;

}
