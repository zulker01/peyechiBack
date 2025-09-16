package com.example.template_spring.Entity;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "found_items")
public class FoundItem {
  @Id
  @Column(name = "id",nullable = false)
  private String id;


  @Column(name = "name",nullable = false)
  private String name;

  @Column(name = "quantity",nullable = false)
  private Integer quantity;

  @Column(name = "description")
  private String description;

  @Column(name = "location",nullable = false)
  private String location;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  @Column(name = "is_claimed",nullable = false)
  private Boolean isClaimed;

  @Column(name = "date",nullable = false)
  private LocalDate date;
}
