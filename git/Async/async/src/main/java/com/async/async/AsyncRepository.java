package com.async.async;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsyncRepository extends JpaRepository<TaskModel, String> {

}
