package com.org.PPMtool.repositories;

import com.org.PPMtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

    Optional<Project> findByProjectIdentifier(String projectId);

    Iterable<Project> findAll();
}
