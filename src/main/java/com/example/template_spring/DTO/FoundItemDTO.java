package com.example.template_spring.DTO;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoundItemDTO {
  private String id;
  private String name;
  @Min(1)
  private Integer quantity;
  private String description;
  private String location;
  private String user;
}