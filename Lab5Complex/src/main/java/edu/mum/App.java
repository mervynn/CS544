package edu.mum;

import edu.mum.domain.Appointment;
import edu.mum.domain.Doctor;
import edu.mum.domain.Patient;
import edu.mum.domain.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Doctor doctor = new Doctor(null, "Eye doctor", "Frank", "Brown");
        Patient patient = new Patient(null, "John Doe", "100 Main Street", "23114", "Boston");
        Appointment appointment = new Appointment(null, "15/05/08", null, patient, doctor);
        Payment payment = new Payment("12/06/08", 100);
        appointment.setPayment(payment);
        em.persist(doctor);
        em.persist(patient);
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em.createQuery("from Appointment").getSingleResult());
        em.getTransaction().commit();
        em.close();
    }
}
