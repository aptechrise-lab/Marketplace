package com.project.marketplaceservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String name;

    private String email;

    private String role;

    private Long Id;

    private Boolean Active;
}
