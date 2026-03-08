package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Username {
    @NotBlank(message = "First name can't be blank")
    @Column(nullable = false)
    private String firstname;

    @NotBlank(message = "Last name can't be blank")
    @Column(nullable = false)
    private String lastname;

    public String getFullName() {
        return String.format("%s %s", firstname, lastname);
    }
}
