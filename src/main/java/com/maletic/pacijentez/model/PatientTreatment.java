package com.maletic.pacijentez.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PatientTreatment")
public class PatientTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "treatmentId", referencedColumnName = "id")
    private Treatment treatmentId;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "appointmentTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "inserterId", referencedColumnName = "id")
    private Employee inserterId;

    @Column(name = "insertedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertedAt;

    public PatientTreatment() {
    }

    public PatientTreatment(Integer id, Patient patientId, Treatment treatmentId, String description, String location, LocalDateTime appointmentTime, Employee inserterId, LocalDateTime insertedAt) {
        this.id = id;
        this.patientId = patientId;
        this.treatmentId = treatmentId;
        this.description = description;
        this.location = location;
        this.appointmentTime = appointmentTime;
        this.inserterId = inserterId;
        this.insertedAt = insertedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Treatment getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Treatment treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Employee getInserterId() {
        return inserterId;
    }

    public void setInserterId(Employee inserterId) {
        this.inserterId = inserterId;
    }

    public LocalDateTime getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(LocalDateTime insertedAt) {
        this.insertedAt = insertedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientTreatment that = (PatientTreatment) o;
        return Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(treatmentId, that.treatmentId) && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(appointmentTime, that.appointmentTime) && Objects.equals(inserterId, that.inserterId) && Objects.equals(insertedAt, that.insertedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, treatmentId, description, location, appointmentTime, inserterId, insertedAt);
    }
}
