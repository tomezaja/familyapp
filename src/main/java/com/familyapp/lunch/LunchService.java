package com.familyapp.lunch;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LunchService implements ILunchService {
    private LunchRepository lunchs;

    public LunchService(LunchRepository lr) {
        super();
        this.lunchs = lr;
    }

    @Override
    public Lunch findById(long id){
        try {
            return this.lunchs.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Lunch> findAll(){
        return this.lunchs.findAll();
    }

    @Override
    public boolean delete(long id){
        Lunch l = this.findById(id);
        try {
            this.lunchs.delete(l);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Lunch create(Lunch l){
        l = this.lunchs.save(l);
        return l;
    }

    

    @Override
    public Lunch update(long id, Lunch formData){
        Lunch oldLunch = this.findById(id);
        if(oldLunch == null){
            return null;
        }
        if (formData.getName() != null) {
            oldLunch.setName(formData.getName());  
        }else{
            oldLunch.setName(oldLunch.getName());
        }
        
       return this.lunchs.save(oldLunch);
    }

}
