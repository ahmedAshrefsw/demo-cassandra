package com.demo.cassandra.repository;

import com.demo.cassandra.model.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface MaterialRepository extends CrudRepository<Material, UUID> {

    Material findByTitle(String title);
}
