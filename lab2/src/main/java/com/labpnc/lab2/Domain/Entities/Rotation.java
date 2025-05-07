package com.labpnc.lab2.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rotation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idRotation;

    @ManyToOne
    @JoinColumn(name = "id_floor", nullable = false, foreignKey = @ForeignKey(name = "FK_rotation_floor"))
    private Floor floor;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "is_active")
    private Boolean isActive;


}
