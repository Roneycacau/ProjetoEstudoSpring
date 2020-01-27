package com.example.project.repository;

import com.example.project.domain.entities.Client;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(nativeQuery = true, value = "select distinct name from Client")
    List<String> listDistinct();

    List<Client> findByPhone(String phone);

    List<Client> findByPhoneOrderByName(String phone);

    List<Client> findByPhoneContainingOrderByName(String phone);
}