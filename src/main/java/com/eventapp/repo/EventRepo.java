package com.eventapp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.entity.EventRegistration;


@Repository

public interface EventRepo extends JpaRepository<EventRegistration, String>{

}
