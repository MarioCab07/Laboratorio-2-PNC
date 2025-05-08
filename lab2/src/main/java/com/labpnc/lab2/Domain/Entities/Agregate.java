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
@Table(name = "agregate")
public class Agregate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAgregate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany
    @JoinColumn(name = "id_agregate", referencedColumnName = "idAgregate", foreignKey = @ForeignKey(name = "FK_room_agregate"))
    private List<Room> room;
}
