package com.maletic.pacijentez.model;

public class PatientTreatment {

<<<<<<< Updated upstream
}
=======
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

    @Column(name = "date")
    private String time;

    @ManyToOne
    @JoinColumn(name = "inserterId", referencedColumnName = "id")
    private Employee inserterId;

    @Column(name = "insertedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertedAt;


}
>>>>>>> Stashed changes
