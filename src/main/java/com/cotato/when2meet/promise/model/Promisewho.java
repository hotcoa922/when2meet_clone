package com.cotato.when2meet.promise.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Promisewho {

    @Id
    private String ID;

    private String N_EN;
}
