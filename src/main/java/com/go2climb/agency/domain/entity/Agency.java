package com.go2climb.agency.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "agencies")
@AllArgsConstructor
@NoArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 75)
    @NotBlank
    @NotNull
    @Column(name = "name")
    private String nombre;

    @NotNull
    @NotBlank
    @Column(name = "photo_url")
    private String photoUrl;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "location")
    private String location;

    @NotNull
    @NotBlank
    @Column(name = "ruc")
    private String ruc;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "stars")
    private Integer stars;

/*    @JsonIgnoreProperties({"agency", "activities", "tips"})
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Travel> travels;*/
}