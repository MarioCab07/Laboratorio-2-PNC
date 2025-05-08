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
@Table(name = "color")
public class Color {

    @Id
    private Integer idColor;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany
    @JoinColumn(name = "id_color_button", referencedColumnName = "idColor", foreignKey = @ForeignKey(name = "FK_floor_color"))
    private List<Floor> floors;

}
