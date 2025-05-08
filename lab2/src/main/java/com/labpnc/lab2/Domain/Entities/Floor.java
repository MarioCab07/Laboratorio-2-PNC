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
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFloor;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "id_color_button", nullable = false,foreignKey = @ForeignKey(name = "FK_floor_color"))
    private Color colorButton;

    @ManyToOne
    @JoinColumn(name = "id_branch", nullable = false,foreignKey = @ForeignKey(name = "FK_floor_branch"))
    private Branch branch;
}
