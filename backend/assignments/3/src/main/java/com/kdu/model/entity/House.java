package com.kdu.model.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "house")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String houseName;

    @ManyToMany(mappedBy = "houses",cascade = CascadeType.ALL)
    private List<UserModel> usersList = new ArrayList<>();

    @OneToMany(mappedBy = "house")
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

}