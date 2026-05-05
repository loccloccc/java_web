package com.example.canteen_wallet.repository;

import com.example.canteen_wallet.model.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
    Page<TransactionHistory> findByWalletId(Long walletId, Pageable pageable);

    @Query("SELECT t FROM TransactionHistory t WHERE t.amount > :min")
    List<TransactionHistory> findByAmountGreaterThan(@Param("min") BigDecimal min);
}
