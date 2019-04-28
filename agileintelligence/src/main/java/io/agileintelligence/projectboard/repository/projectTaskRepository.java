package io.agileintelligence.projectboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.projectboard.domain.projectTask;

@Repository
public interface projectTaskRepository extends CrudRepository<projectTask,Long> {

	projectTask getById(Long id);
}
