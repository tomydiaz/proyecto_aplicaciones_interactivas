package com.uade.grupo5.api_trabajo_practico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.grupo5.api_trabajo_practico.repositories.WishListItemRepository;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.WishListItem;

@Service
public class WishListItemService {
  @Autowired
  private WishListItemRepository wishListItemRepository;

  public List<WishListItem> findAllWishList() throws Exception{
    return wishListItemRepository.findAll();
  }
}