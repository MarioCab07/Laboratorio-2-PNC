package com.labpnc.lab2.Domain.Entities;


/*
*
* Id
	idUsuario
	idSucursal
	Departamento
	idSuperior
	isManager
	idRotacion

* */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEmployee;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_employee_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_branch", nullable = false, foreignKey = @ForeignKey(name = "FK_employee_branch"))
    private Branch branch;

    @Column(name = "department")
    private String department;

    @Column(name = "is_manager")
    private Boolean isManager;

    @ManyToOne
    @JoinColumn(name = "id_superior", nullable = false, foreignKey = @ForeignKey(name = "FK_employee_superior"))
    private Employee superior;

    @ManyToOne
    @JoinColumn(name = "id_rotation", nullable = false, foreignKey = @ForeignKey(name = "FK_employee_rotation"))
    private Rotation rotation;
}
