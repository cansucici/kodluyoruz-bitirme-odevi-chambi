package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Authors,Long> {


}

