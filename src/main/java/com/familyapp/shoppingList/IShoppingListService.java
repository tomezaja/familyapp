package com.familyapp.shoppingList;

import java.util.List;

public interface IShoppingListService {

    ShoppingList findById(long id);

    List<ShoppingList> findAll();

    boolean delete(long id);

    ShoppingList create(ShoppingList shoppingList);

    ShoppingList update(long id, ShoppingList formData);
}
