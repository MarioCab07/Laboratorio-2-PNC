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
@Table(name = "user_x_gift")
public class UserXGift {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUserGift;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_usergift_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_gift", nullable = false, foreignKey = @ForeignKey(name = "FK_usergift_gift"))
    private Gift gift;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_usergift_employee"))
    private Employee employee; // quién otorgó o autorizó

    @Column(name = "redeem_date", nullable = false)
    private String redeemDate;

    @Column(name = "points_used", nullable = false)
    private Integer pointsUsed;
}
