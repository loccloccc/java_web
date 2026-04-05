package org.example.bai3;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}
