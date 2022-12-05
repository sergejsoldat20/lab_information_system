package lis.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "spetialization", nullable = false, length = 100)
    private String spetialization;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "role", nullable = false, length = 45)
    private String role;
    @OneToMany(mappedBy = "user")
    private List<MedicalRecordEntity> medicalRecords;
}
