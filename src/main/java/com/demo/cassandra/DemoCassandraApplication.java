package com.demo.cassandra;

import com.demo.cassandra.model.Material;
import com.demo.cassandra.repository.MaterialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class DemoCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCassandraApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(MaterialRepository materialRepository) {
		return args -> {
			materialRepository.deleteAll();

			Material m1 = new Material(UUID.randomUUID(), "Accessing Data with Cassandra",
					"https://spring.io/guides/gs/accessing-data-cassandra/", new HashSet<>(List.of("databases","spring")));
			Material m2 = new Material(UUID.randomUUID(), "Spring initializer", "https://start.spring.io/",
					new HashSet<>(List.of("spring","start")));

			Material savedM1 = materialRepository.save(m1);
			Material savedM2 = materialRepository.save(m2);

			materialRepository.findAll()
					.forEach(material -> log.info("Material: {}", material.getTitle()));

			materialRepository.findById(savedM1.getId())
					.ifPresent(material -> log.info("Material by id: {}", material.getTitle()));
		};
	}

}
