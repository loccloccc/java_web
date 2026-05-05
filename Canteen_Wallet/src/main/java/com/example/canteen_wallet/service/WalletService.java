package com.example.canteen_wallet.service;

import com.example.canteen_wallet.model.TransactionHistory;
import com.example.canteen_wallet.model.Wallet;
import com.example.canteen_wallet.repository.TransactionHistoryRepository;
import com.example.canteen_wallet.repository.WalletRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final TransactionHistoryRepository historyRepository;

    @Transactional
    public void transferMoney(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        Wallet fromWallet = walletRepository.findById(fromWalletId)
                .orElseThrow(() -> new RuntimeException("Wallet A not found"));
        Wallet toWallet = walletRepository.findById(toWalletId)
                .orElseThrow(() -> new RuntimeException("Wallet B not found"));

        if (fromWallet.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        fromWallet.setBalance(fromWallet.getBalance().subtract(amount));
        toWallet.setBalance(toWallet.getBalance().add(amount));

        historyRepository.save(new TransactionHistory(null, amount, fromWallet));
        historyRepository.save(new TransactionHistory(null, amount, toWallet));

        // Giả lập lỗi để kiểm tra rollback
        if (true) {
            throw new RuntimeException("Fake error to test rollback");
        }
    }

    @Transactional()
    public void saveSystemLog(String message) {
        System.out.println("LOG: " + message);
    }
}

