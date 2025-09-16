package com.example.template_spring.Repository;

import com.example.template_spring.Entity.FoundItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundItemRepository extends JpaRepository<FoundItem, String> {
  Page<FoundItem> findByUserId(String userId, Pageable pageable);
}
