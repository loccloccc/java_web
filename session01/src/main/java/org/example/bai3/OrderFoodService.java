package org.example.bai3;

import org.springframework.stereotype.Service;

@Service
public class OrderFoodService {

    private InventoryRepository inventoryRepository;
    private UserAccountRepository userAccountRepository;

    public OrderFoodService(
            InventoryRepository inventoryRepository,
            UserAccountRepository userAccountRepository
    ){
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void orderFood(String username, String foodName, int quantity){

        int stock = inventoryRepository.getFoodQuantity(foodName);

        if(stock <= 0){
            throw new RuntimeException("Food out of stock");
        }

        double price = inventoryRepository.getFoodPrice(foodName);
        double total = price * quantity;

        double balance = userAccountRepository.getBalance(username);

        if(balance < total){
            throw new RuntimeException("Not enough balance");
        }

        userAccountRepository.deductBalance(username,total);
        inventoryRepository.reduceFood(foodName,quantity);

        System.out.println("Order Success");
    }
}
