package com.labpnc.lab2.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idWorkOrder;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_work_order_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_work_order_room"))
    private Room room;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name ="hour")
    private String hour;


}
