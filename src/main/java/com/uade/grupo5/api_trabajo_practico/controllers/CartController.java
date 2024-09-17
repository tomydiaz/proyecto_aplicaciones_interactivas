package com.uade.grupo5.api_trabajo_practico.controllers;

import com.uade.grupo5.api_trabajo_practico.dto.ItemDTO;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.Cart;
import com.uade.grupo5.api_trabajo_practico.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    // Obtener el carrito por ID
    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    // Crear carrito (invocado al crear usuario - pasa ID por parametro)
    @PostMapping("")
    public Cart createCart(@RequestBody Long userID) {
        return cartService.createCart(userID);
    }

    // Agregar un ítem al carrito
    @PostMapping("/{cartId}/item")
    public Cart addItemToCart(@PathVariable Long cartId, @RequestBody ItemDTO itemDTO) {
        cartService.addItemToCart(cartId, itemDTO);
        return cartService.getCartById(cartId);
    }

    // Eliminar un ítem del carrito por el ID del producto
    @DeleteMapping("/{cartId}/item/{productId}")
    public Cart removeItemFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        cartService.removeItemFromCart(cartId, productId);
        return cartService.getCartById(cartId);
    }
    // Eliminar un ítem del carrito por el ID del producto
    @PutMapping("/{cartId}")
    public void removeCart(@PathVariable Long cartId) {
        cartService.emptyCart(cartId);
    }


}
