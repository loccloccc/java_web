package org.example.ecommerce.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Order;
import org.example.ecommerce.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String checkoutPage(HttpSession session, Model model) {
        model.addAttribute("cart", session.getAttribute("cart"));
        model.addAttribute("order", new Order());
        return "client/checkout";
    }

    @PostMapping
    public String placeOrder(@ModelAttribute Order order, HttpSession session, RedirectAttributes ra) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            ra.addFlashAttribute("error", "Giỏ hàng trống");
            return "redirect:/cart";
        }
        try {
            orderService.placeOrder(order, cart);
            session.removeAttribute("cart");
            return "redirect:/checkout/success";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/cart";
        }
    }

    @GetMapping("/success")
    public String success() {
        return "client/success";
    }
}