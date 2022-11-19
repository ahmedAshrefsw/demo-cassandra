package com.demo.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table
@AllArgsConstructor
@Data
public class Material {

    @PrimaryKey
    private UUID id;

    private String title;
    private String link;

    private Set<String> tags;


}
