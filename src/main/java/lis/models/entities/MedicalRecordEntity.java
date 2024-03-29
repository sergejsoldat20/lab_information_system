package lis.models.entities;

import jakarta.persistence.*;
import lis.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "medical_record")
@SQLDelete(sql = "UPDATE medical_record SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@EntityListeners(AuditingEntityListener.class)

public class MedicalRecordEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "icd", nullable = false, length = 20)
    private String icd;
    @Basic
    @Column(name = "is_valid", nullable = true)
    private String isValid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hematology_id", referencedColumnName = "id")
    private HematologyEntity hematology;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urine_id", referencedColumnName = "id")
    private UrineEntity urine;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biochemistry_id", referencedColumnName = "id")
    private BiochemistryEntity biochemistry;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private PatientEntity patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @Basic
    @Column(name = "created_time", nullable = true)
    private Timestamp createdTime;
    @Basic
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = Boolean.FALSE;
}
