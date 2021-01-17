package org.kodluyoruz.group1.library;

import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MemberRepository.class)
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}
}
