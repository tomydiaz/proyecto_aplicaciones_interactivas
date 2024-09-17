package com.uade.grupo5.api_trabajo_practico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.grupo5.api_trabajo_practico.repositories.BuyRepository;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.Buy;

@Service
public class BuyService {
  @Autowired
  private BuyRepository buyRepository;

  public List<Buy> getBuys() throws Exception {
    List<Buy> buys = buyRepository.findAll();
    return buys;
  }

  /*
   * public List<Buy> getUserBuys(Long userId) throws Exception{
   * return buyRepository.findByUserId(userId);
   * }
   */

  public void createBuy(Buy buy) throws Exception {
    buyRepository.save(buy);
  }

  /*
   * public void deleteBuy(Long id) throws Exception{
   * 
   * }
   */
}
