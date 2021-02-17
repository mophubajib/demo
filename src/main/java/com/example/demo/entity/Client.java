package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @Column(name = "number_phone")
    private String numberPhone;
    @Column(name ="balance")
    private int balance;
    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy="recipient")
    private List<Payment> recipientPayments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="sender")
    private List<Payment> senderPayments;
}
