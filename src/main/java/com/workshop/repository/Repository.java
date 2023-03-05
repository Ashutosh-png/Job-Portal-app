package com.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.workshop.Entity.Application;
import com.workshop.Entity.User;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Application, Long> {




}
