package com.labpnc.lab2.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Salon")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idSalon;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "ornaments")
    private String ornaments;

    @ManyToOne
    @JoinColumn(name = "id_branch", nullable = false,foreignKey = @ForeignKey(name = "FK_salon_branch"))
    private Branch branch;
}
