package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "user_id")
    private UUID user_id;


}
