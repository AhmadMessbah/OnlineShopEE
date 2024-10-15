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
@NamedQueries({
        @NamedQuery(name = "Person.findByNationalId",query = "select pp from personEntity pp where pp.nationalId like : nationalId and pp.deleted=false "),
        @NamedQuery(name = "Person.findByLastNameAndFirstName",query = "select pp from personEntity pp where pp.family like : family and pp.name like : name and pp.deleted=false "),
        @NamedQuery(name = "Person.findByPhoneNumber",query = "select pp from personEntity pp where pp.phoneNumber like : phoneNumber and pp.deleted=false "),
        @NamedQuery(name = "Person.findByPostalCode",query = "select pp from personEntity pp where pp.postalCode like : postalCode and pp.deleted=false "),
        @NamedQuery(name = "Person.findByAddress",query = "select pp from personEntity pp where pp.address like : address and pp.deleted=false "),
 //todo @NamedQuery(name = "Person.findByUserId",query = "select pp from personEntity pp where pp.user.id = : user")
})

public class Person extends Base{

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

    @OneToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "person_users",foreignKey = @ForeignKey(name = "my_fk"))
    private User user;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
