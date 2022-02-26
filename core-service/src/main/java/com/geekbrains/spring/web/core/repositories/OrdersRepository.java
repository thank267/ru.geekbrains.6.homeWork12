package com.geekbrains.spring.web.core.repositories;

import com.geekbrains.spring.web.core.entities.Order;
import com.geekbrains.spring.web.core.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.username = ?1")
    List<Order> findAllByUsername(String username);

    @Modifying
    @Query("update Order o set o.status = :status where o.id = :id")
    void updateStatus(Status status, Long id);
}
