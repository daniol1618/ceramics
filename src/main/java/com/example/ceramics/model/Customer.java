package com.example.ceramics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Comparable<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer age;

    @PrePersist
    void onSave() {
        createdAt = LocalDateTime.now();
    }

    @Override
    public int compareTo(Customer other) {
        return this.age.compareTo(other.age);
    }
}
