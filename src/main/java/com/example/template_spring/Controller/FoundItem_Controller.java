package com.example.template_spring.Controller;

import com.example.template_spring.DTO.FoundItemDTO;
import com.example.template_spring.DTO.PaginationDTO;
import com.example.template_spring.DTO.ResponseModelDTO;
import com.example.template_spring.DTO.UserDTO;
import com.example.template_spring.Service.FoundItemService;
import com.example.template_spring.Service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FoundItem_Controller {
  private final FoundItemService service;


@PostMapping("/api/foundItem/create")
public ResponseEntity<ResponseModelDTO<?>> createFoundItem(@RequestBody @Valid FoundItemDTO dto) {
    try {
        FoundItemDTO createdItem = service.saveFoundItem(dto);
        return ResponseEntity.ok(ResponseModelDTO.success(createdItem, "Item created successfully"));
    } catch (Exception e) {
      throw new RuntimeException("An error occurred: " + e.getMessage());
    }
}

  @PostMapping("/api/default/foundItem")
  public ResponseEntity<ResponseModelDTO<?>> getItems(@RequestBody PaginationDTO dto) {
    try {
      List<FoundItemDTO> items = service.getDefaultItemsByPagination(dto);
      return ResponseEntity.ok(ResponseModelDTO.success(items, "Items retrieved successfully"));
    } catch (Exception e) {
      throw new RuntimeException("An error occurred: " + e.getMessage());
    }
  }

}
