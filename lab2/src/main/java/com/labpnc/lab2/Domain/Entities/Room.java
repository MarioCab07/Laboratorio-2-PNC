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
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRoom;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_agregate", nullable = false,foreignKey = @ForeignKey(name = "FK_room_agregate"))
    private Agregate agregate;

    @ManyToOne
    @JoinColumn(name = "id_floor", nullable = false,foreignKey = @ForeignKey(name = "FK_room_floor"))
    private Floor floor;
}
