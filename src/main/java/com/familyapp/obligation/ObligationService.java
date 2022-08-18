package com.familyapp.obligation;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ObligationService implements IObligationService {

    private ObligationRepository obligations;

    public ObligationService(ObligationRepository or) {
        super();
        this.obligations = or;
    }

    @Override
    public Obligation findById(long id){
        try {
            return this.obligations.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Obligation> findAll(){
        return this.obligations.findAll();
    }

    @Override
    public boolean delete(long id){
        Obligation o = this.findById(id);
        try {
            this.obligations.delete(o);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Obligation create(Obligation o){
        o = this.obligations.save(o);
        return o;
    }

    

    @Override
    public Obligation update(long id, Obligation formData){
        Obligation oldObligation = this.findById(id);
        if(oldObligation == null){
            return null;
        }
        if (formData.getName() != null) {
            oldObligation.setName(formData.getName());  
        }else{
            oldObligation.setName(oldObligation.getName());
        }
        if (formData.getDescription() != null) {
            oldObligation.setDescription(formData.getDescription());  
        }else{
            oldObligation.setDescription(oldObligation.getDescription());
        }
        if (formData.getDate() != null) {
            oldObligation.setDate(formData.getDate());  
        }else{
            oldObligation.setDate(oldObligation.getDate());
        }
        
       

        return this.obligations.save(oldObligation);
    }


}
    

