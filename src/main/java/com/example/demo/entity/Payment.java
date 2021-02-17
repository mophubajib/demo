package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    private String data;
    private int amount;
    private String message;
//    @Column(name = "recipient_id")
//    @NonNull
//    private int recipientId;
//    @Column(name = "sender_id")
//    @NonNull
//    private int senderId;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    Client recipient;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    Client sender;








}
