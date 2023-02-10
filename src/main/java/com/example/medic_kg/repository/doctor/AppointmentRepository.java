package com.example.medic_kg.repository.doctor;

import com.example.medic_kg.entity.doctor.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value="SELECT a.id, a.starttime, a.endtime, p.id AS patient_id, u.username AS username, u.email AS email " +
            "FROM medic_kg.appointments_doctor as a, medic_kg.patients as p, medic_kg.users as u " +
            "WHERE a.patient_id = p.id " +
            "AND u.id = p.id " +
            "AND a.starttime > CAST(:selectedDate AS DATE)"
            , nativeQuery = true)
    List<Appointment> getAppointmentsAfterThisDate(@Param("selectedDate") Date selectedDate);

    @Query(value="SELECT a.id as appid, a.starttime, a.endtime, a.status, a.doctor_id as doctorid, u.username as doctorfn FROM medic_kg.appointments_doctor as a, medic_kg.doctors as d, medic_kg.users as u " +
            "WHERE a.doctor_id = d.id " +
            "AND d.id = u.id " +
            "AND a.patient_id = :patientId "
            , nativeQuery = true)
    List<Appointment> getAppointmentsByPatientId(@Param("patientId") int patientId);

    @Query(value="SELECT a.id as appid, a.starttime, a.endtime, a.doctorid_fk as doctorid, u.firstname as doctorfn, u.lastname as doctorln " +
            "FROM medic_kg.appointments_doctor as a, medic_kg.doctors as d, medic_kg.users as u " +
            "WHERE a.doctor_id = d.id " +
            "AND d.id = u.id " +
            "AND status = :status " +
            "AND a.patient_id = :patientId "
            , nativeQuery = true)
    List<Appointment> getAppointmentsByPatientIdAndStatus(@Param("patientId") int patientId, @Param("status") int status);
}
