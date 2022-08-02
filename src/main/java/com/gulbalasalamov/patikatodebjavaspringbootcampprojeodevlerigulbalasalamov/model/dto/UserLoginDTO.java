package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;

@Getter
public class UserLoginDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
