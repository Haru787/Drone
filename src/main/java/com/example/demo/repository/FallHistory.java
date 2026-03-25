// package com.example.demo.repository;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// import org.hibernate.annotations.CreationTimestamp;

// @Entity
// @Table(name = "dca")
// public class FallHistory {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @CreationTimestamp
//     @Column(name = "created_at",updatable = false)
//     private LocalDateTime createdAt;

//     @Column(name = "input_altitude", nullable = false)
//     private double altitude;

//     @Column(name = "input_speed", nullable = false)
//     private double speed;

//     @Column(name = "input_wind", nullable = false)
//     private double wind;

//     @Column(name = "result", nullable = false)
//     private double result;

//     // --- JPA用（必須） ---
//     protected FallHistory() {}

//     // --- 保存用コンストラクタ ---
//     public FallHistory(double altitude, double speed, double wind, double result) {
//         this.altitude = altitude;
//         this.speed = speed;
//         this.wind = wind;
//         this.result = result;
//     }

//     // --- getter（setterは最小限） ---
//     public Long getId() { return id; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public double getAltitude() { return altitude; }
//     public double getSpeed() { return speed; }
//     public double getWind() { return wind; }
//     public double getResult() { return result; }
// }