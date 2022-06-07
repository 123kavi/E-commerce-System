package com.cylonomic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.cylonomic.domain.Order;
import com.cylonomic.domain.User;

public interface OrderRepository extends CrudRepository<Order, Long> {



}
