package com.tn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "school")
public class School{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String schoolName;

    private String address;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
