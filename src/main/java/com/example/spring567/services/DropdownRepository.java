package com.example.spring567.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring567.models.Dropdown;

public interface DropdownRepository extends JpaRepository<Dropdown, Integer> {

}
