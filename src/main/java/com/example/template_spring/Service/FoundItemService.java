package com.example.template_spring.Service;

import com.example.template_spring.DTO.FoundItemDTO;
import com.example.template_spring.DTO.UserDTO;
import com.example.template_spring.Entity.FoundItem;
import com.example.template_spring.Entity.User;
import com.example.template_spring.Repository.FoundItemRepository;
import com.example.template_spring.Repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FoundItemService {
  private final FoundItemRepository foundItemRepository;

  public FoundItemDTO saveFoundItem(FoundItemDTO dto) {
    FoundItem foundItem = new FoundItem();
    foundItem.setId(UUID.randomUUID().toString());
    foundItem.setName(dto.getName());
    foundItem.setQuantity(dto.getQuantity());
    foundItem.setDescription(dto.getDescription());
    foundItem.setLocation(dto.getLocation());
    foundItem.setUser(dto.getUser());
    foundItemRepository.save(foundItem);
    dto.setId(foundItem.getId());
    return dto;
  }

  public List<FoundItemDTO> getAllItems() {
    List<FoundItem> foundItems = foundItemRepository.findAll();
    return foundItems.stream().map(item -> {
      FoundItemDTO dto = new FoundItemDTO();
      dto.setId(item.getId());
      dto.setName(item.getName());
      dto.setQuantity(item.getQuantity());
      dto.setDescription(item.getDescription());
      dto.setLocation(item.getLocation());
      dto.setUser(item.getUser());
      return dto;
    }).toList();
  }
}