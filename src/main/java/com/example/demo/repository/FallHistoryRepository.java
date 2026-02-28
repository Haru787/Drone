package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FallHistory;

public interface FallHistoryRepository
        extends JpaRepository<FallHistory, Long> {

        List<FallHistory> findTop25ByOrderByCreatedAtDesc();
}
