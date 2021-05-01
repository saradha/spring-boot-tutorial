package com.saradha.multipledatasource.model.contact;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//h2
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String houseNo;
    private String streetName;
    private String zipCode;
    private String state;
    private String country;
}
