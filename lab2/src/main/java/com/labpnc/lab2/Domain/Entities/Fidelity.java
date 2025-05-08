package com.labpnc.lab2.Domain.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fidelity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFidelity;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_fidelity_employee"))
    private Employee employee;

    @Column(name = "points")
    private Integer points;

    @Column(name = "date")
    private String date;

}
