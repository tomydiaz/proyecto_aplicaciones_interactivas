package com.uade.grupo5.api_trabajo_practico.services;

import java.time.LocalDate;
import java.util.List;

import com.uade.grupo5.api_trabajo_practico.repositories.entities.BuyItem;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.grupo5.api_trabajo_practico.repositories.BuyRepository;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.Buy;

@Service
public class BuyService {
  @Autowired
  private BuyRepository buyRepository;

  // ** SIRVE **
  public List<Buy> getUserBuys(Long userId) throws Exception {
    return buyRepository.findByUserId(userId);
  }

  // ** SIRVE **
  public Buy createBuy(Cart cart) throws Exception {
    Buy buy = Buy.builder()
        .buyDate(LocalDate.now())
        .user(cart.getUser())
        .build();

    List<BuyItem> buyItems = cart.generateBuyItems();

    buy.setItems(buyItems);

    return buyRepository.save(buy);
  }

}
