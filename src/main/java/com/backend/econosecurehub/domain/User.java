package com.backend.econosecurehub.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/**
 * @author
 * @version 1.0
 * @since
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class User {
    private Long id;
    @NotEmpty(message = "FIRST NAME CANNOT BE EMPTY")
    private String firstName;
    @NotEmpty(message = "LASTNAME CANNOT BE EMPTY")
    private String lastName;
    @NotEmpty(message = "EMAIL CANNOT BE EMPTY")
    @Email(message = "INVALID EMAIL. ENTER A VALID EMAIL ADDRESS")
    private String email;
    @NotEmpty(message = "PASSWORD CANNOT BE EMPTY")
    private String password;
    private String address;
    private String phone;
    private String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean isUsingMfa;
    private LocalDateTime createdAt;

}
