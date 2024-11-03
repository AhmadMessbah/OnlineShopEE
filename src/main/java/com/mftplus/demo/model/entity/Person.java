package com.mftplus.demo.model.entity;

import com.mftplus.demo.model.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

public class Person extends Base {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSeq")
    private Long id;

    @Column(name = "person_firstName", length = 30, nullable = false)
    @Pattern(regexp = "^[a-zA-Z]{2,30}$", message = "invalid name !")
    private String name;

    @Column(name = "person_lastName", length = 40, nullable = false)
    @Pattern(regexp = "^[a-zA-Z]{2,40}$", message = "invalid family")
    private String family;

    @Column(name = "person_national_id", length = 10, nullable = false)
    @Pattern(regexp = "^[0-9]{3,10}$", message = "invalid national id !")
    private String nationalId;

    @Column(name = "person_birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "person_phone_number", length = 13, nullable = false)
    @Pattern(regexp = "^[0-9]{3,13}$", message = "invalid phone number !")
    private String phoneNumber;

    @Column(name = "person_address", length = 200, nullable = false)
    @Pattern(regexp = "^[a-zA-Z\\s]{5,200}$", message = "invalid address text !")
    private String address;

    @Column(name = "person_postal_code", length = 30)
    @Pattern(regexp = "^[0-9]{1,30}$", message = "invalid postalCode !")
    private String postalCode;

    @Column(name = "person_gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;


    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_users", foreignKey = @ForeignKey(name = "my_fk"))
    private User user;

}
