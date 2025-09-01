package com.example.template_spring.Repository;

import com.example.template_spring.Entity.FoundItem;
import com.example.template_spring.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoundItemRepository extends JpaRepository<FoundItem, String> {
}
