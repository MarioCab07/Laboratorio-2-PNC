package com.labpnc.lab2.Domain.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    @Column(name = "active")
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "id_salon", nullable = false)
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;
}
