package com.example.template_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO {
  private int current;
  private int size;
  private int total;
}
