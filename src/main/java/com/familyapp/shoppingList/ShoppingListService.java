package com.familyapp.shoppingList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShoppingListService implements IShoppingListService {

    private ShoppingListRepository shoppingLists;

    public ShoppingListService(ShoppingListRepository slr) {
        super();
        this.shoppingLists = slr;
    }

    @Override
    public ShoppingList findById(long id){
        try {
            return this.shoppingLists.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ShoppingList> findAll(){
        return this.shoppingLists.findAll();
    }

    @Override
    public boolean delete(long id){
        ShoppingList sl = this.findById(id);
        try {
            this.shoppingLists.delete(sl);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public ShoppingList create(ShoppingList sl){
        sl = this.shoppingLists.save(sl);
        return sl;
    }

    

    @Override
    public ShoppingList update(long id, ShoppingList formData){
        ShoppingList oldShoppingList = this.findById(id);
        if(oldShoppingList == null){
            return null;
        }
        if (formData.getName() != null) {
            oldShoppingList.setName(formData.getName());  
        }else{
            oldShoppingList.setName(oldShoppingList.getName());
        }
        
            oldShoppingList.setQuantity(oldShoppingList.getQuantity());
        
             
       
        return this.shoppingLists.save(oldShoppingList);
    }


}
    

