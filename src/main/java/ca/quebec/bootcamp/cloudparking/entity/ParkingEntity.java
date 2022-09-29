package ca.quebec.bootcamp.cloudparking.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_parking")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String license;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private LocalDateTime entryDate;

    @Column(nullable = false)
    private LocalDateTime exitDate;

    @Column(nullable = false)
    private Double bill;

}
