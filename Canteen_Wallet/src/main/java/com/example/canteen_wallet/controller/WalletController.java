package com.example.canteen_wallet.controller;

import com.example.canteen_wallet.repository.WalletRepository;
import com.example.canteen_wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;
    private final WalletRepository walletRepository;

    @GetMapping("/wallets")
    public String listWallets(Model model) {
        model.addAttribute("wallets", walletRepository.findAll());
        return "wallets";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromId,
                           @RequestParam Long toId,
                           @RequestParam BigDecimal amount,
                           RedirectAttributes redirectAttributes) {
        try {
            walletService.transferMoney(fromId, toId, amount);
            redirectAttributes.addFlashAttribute("success", "Transfer successful!");
        } catch (Exception e) {
            walletService.saveSystemLog(e.getMessage());
            redirectAttributes.addFlashAttribute("error", "Transfer failed: " + e.getMessage());
        }
        return "redirect:/wallets";
    }
}
