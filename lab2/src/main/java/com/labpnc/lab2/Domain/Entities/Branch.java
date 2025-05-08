package com.labpnc.lab2.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idBranch;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToMany
    @JoinColumn(name = "id_branch", referencedColumnName = "idBranch",foreignKey = @ForeignKey(name = "FK_floor_branch"))
    private List<Floor> floors;

    @OneToMany
    @JoinColumn(name = "id_branch", referencedColumnName = "idBranch",foreignKey = @ForeignKey(name = "FK_salon_branch"))
    private List<Salon> salon;
}
