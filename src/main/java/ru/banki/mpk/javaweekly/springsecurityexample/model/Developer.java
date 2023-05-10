package ru.banki.mpk.javaweekly.springsecurityexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer implements Serializable {

    @Serial
    private static final long serialVersionUID = -3029448291999709851L;

    private Long id;

    private String firstName;

    private String lastName;

}
