package com.example.springmapstruct.repository;

import com.example.springmapstruct.model.Atlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtleteRepository extends JpaRepository<Atlete, Integer> {
}
