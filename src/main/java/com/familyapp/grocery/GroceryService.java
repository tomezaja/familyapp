package com.familyapp.grocery;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GroceryService implements IGroceryService {

    private GroceryRepository groceries;

    public GroceryService(GroceryRepository gr) {
        super();
        this.groceries = gr;
    }

    @Override
    public Grocery findById(long id){
        try {
            return this.groceries.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Grocery> findAll(){
        return this.groceries.findAll();
    }

    @Override
    public boolean delete(long id){
        Grocery g = this.findById(id);
        try {
            this.groceries.delete(g);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Grocery create(Grocery g){
        g = this.groceries.save(g);
        return g;
    }

    

    @Override
    public Grocery update(long id, Grocery formData){
        Grocery oldGrocery = this.findById(id);
        if(oldGrocery == null){
            return null;
        }
        if (formData.getName() != null) {
            oldGrocery.setName(formData.getName());  
        }else{
            oldGrocery.setName(oldGrocery.getName());
        }
        if (formData.getUnit() != null) {
            oldGrocery.setUnit(formData.getUnit());  
        }else{
            oldGrocery.setUnit(oldGrocery.getUnit());
        }
             
        return this.groceries.save(oldGrocery);
    }


}
    

