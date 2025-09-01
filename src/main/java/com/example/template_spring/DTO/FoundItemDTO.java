package com.example.template_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoundItemDTO {
  private String id;
  private String name;
  private String quantity;
  private String description;
  private String location;
  private String user;
}