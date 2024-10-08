package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import com.mftplus.demo.model.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "personEntity")
@Table(name = "person_tbl")

public class Person {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSeq")
    private Long id;

    @Column(name = "person_firstName", length = 30, nullable = false)
    private String name;

    @Column(name = "person_lastName", length = 40, nullable = false)
    private String family;

    @Column(name = "person_national_id", length = 10, nullable = false)
    private String nationalId;

    @Column(name = "person_birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "person_phone_number", length = 13, nullable = false)
    private String phoneNumber;

    @Column(name = "person_address", length = 200, nullable = false)
    private String address;

    @Column(name = "person_postal_code")
    private String postalCode;

    @Column(name = "person_gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "person_users")
    private User user;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
