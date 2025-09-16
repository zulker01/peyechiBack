package com.example.template_spring.Service;

import com.example.template_spring.DTO.FoundItemDTO;
import com.example.template_spring.DTO.PaginationDTO;
import com.example.template_spring.Entity.FoundItem;
import com.example.template_spring.Repository.FoundItemRepository;
import com.example.template_spring.Repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FoundItemService {
  private final FoundItemRepository foundItemRepository;
  private final UserRepository userRepository;

  public FoundItemDTO saveFoundItem(FoundItemDTO dto) {
    FoundItem foundItem = new FoundItem();
    foundItem.setId(UUID.randomUUID().toString());
    foundItem.setName(dto.getName());
    foundItem.setQuantity(dto.getQuantity());
    foundItem.setDescription(dto.getDescription());
    foundItem.setLocation(dto.getLocation());
    foundItem.setUser(userRepository.findById(dto.getUser()).orElseThrow(()->new RuntimeException("User not found")) );
    foundItem.setIsClaimed(false);
    foundItem.setDate(dto.getDateFound()==null? LocalDate.now():dto.getDateFound());
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
      dto.setUser(item.getUser().getUsername());
      return dto;
    }).toList();
  }

  public List<FoundItemDTO> getDefaultItemsByPagination(PaginationDTO dto){
    try{
      Page<FoundItem> page = foundItemRepository.findAll(
              PageRequest.of(dto.getCurrent(), dto.getSize(),Sort.by("date")));
      return page.stream().map(item -> {
        FoundItemDTO foundItemDTO = new FoundItemDTO();
        foundItemDTO.setId(item.getId());
        foundItemDTO.setName(item.getName());
        foundItemDTO.setQuantity(item.getQuantity());
        foundItemDTO.setDescription(item.getDescription());
        foundItemDTO.setLocation(item.getLocation());
        foundItemDTO.setUser(item.getUser().getUsername());
        return foundItemDTO;
      }).toList();
    }catch (Exception e){
      throw new RuntimeException("An error occurred: " + e.getMessage());
    }
  }
}