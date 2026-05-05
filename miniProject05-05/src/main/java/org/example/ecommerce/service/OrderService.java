package org.example.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Order;
import org.example.ecommerce.model.OrderDetail;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.OrderRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void placeOrder(Order order, List<CartItem> cart) {
        List<OrderDetail> details = new ArrayList<>();
        for (CartItem item : cart) {
            Product product = productRepository.findById(item.getProductId()).orElseThrow();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Sản phẩm " + product.getName() + " không đủ số lượng");
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            OrderDetail detail = new OrderDetail();
            detail.setProduct(product);
            detail.setQuantity(item.getQuantity());
            detail.setPrice(product.getPrice());
            detail.setOrder(order);
            details.add(detail);
        }
        double total = 0;

        for (OrderDetail detail : details) {
            total += detail.getPrice() * detail.getQuantity();
        }

        order.setTotalPrice(total);
        order.setOrderDetails(details);
        orderRepository.save(order);
    }
}