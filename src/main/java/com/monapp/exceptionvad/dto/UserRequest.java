package com.monapp.exceptionvad.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    private int userId;
    @NotNull(message = "le nom doit pas etre null")
    private String name;
    @Email(message = "email non valide")
    private String email;
    @Pattern(regexp = "^\\d{9}$", message = "numero non valide")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
