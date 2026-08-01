package dev.waddadelmehdi.billingservice.dao.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private Long id;
    private String nom;
    private String email;
}