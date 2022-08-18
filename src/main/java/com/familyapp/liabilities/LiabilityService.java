package com.familyapp.liabilities;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LiabilityService implements ILiabilityService {

    private LiabilityRepository liabilities;

    public LiabilityService(LiabilityRepository lr) {
        super();
        this.liabilities = lr;
    }

    @Override
    public Liability findById(long id){
        try {
            return this.liabilities.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Liability> findAll(){
        return this.liabilities.findAll();
    }

    @Override
    public boolean delete(long id){
        Liability l = this.findById(id);
        try {
            this.liabilities.delete(l);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Liability create(Liability l){
        l = this.liabilities.save(l);
        return l;
    }

    

    @Override
    public Liability update(long id, Liability formData){
        Liability oldLiability = this.findById(id);
        if(oldLiability == null){
            return null;
        }
        if (formData.getName() != null) {
            oldLiability.setName(formData.getName());  
        }else{
            oldLiability.setName(oldLiability.getName());
        }
        if (formData.getDate() != null) {
            oldLiability.setDate(formData.getDate());  
        }else{
            oldLiability.setDate(oldLiability.getDate());
        }
       
       

        return this.liabilities.save(oldLiability);
    }


}
    

