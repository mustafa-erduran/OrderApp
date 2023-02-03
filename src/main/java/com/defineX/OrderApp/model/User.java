package com.defineX.OrderApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    private String surname;
    private String email;
    private String registerDate;

}
