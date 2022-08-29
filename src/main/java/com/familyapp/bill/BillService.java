package com.familyapp.bill;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {

    private BillRepository bills;

    public BillService(BillRepository br) {
        super();
        this.bills = br;
    }

    @Override
    public Bill findById(long id){
        try {
            return this.bills.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Bill> findAll(){
        return this.bills.findAll();
    }

    @Override
    public boolean delete(long id){
        Bill b = this.findById(id);
        try {
            this.bills.delete(b);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Bill create(Bill b){
        b = this.bills.save(b);
        return b;
    }

    

    @Override
    public Bill update(long id, Bill formData){
        Bill oldBill = this.findById(id);
        if(oldBill == null){
            return null;
        }
        if (formData.getName() != null) {
            oldBill.setName(formData.getName());  
        }else{
            oldBill.setName(oldBill.getName());
        }
        
            oldBill.setPrice(oldBill.getPrice());
        
        if (formData.getMonth() != null) {
            oldBill.setMonth(formData.getMonth());  
        }else{
            oldBill.setMonth(oldBill.getMonth());
        }
        if (formData.getDueDate() != null) {
            oldBill.setDueDate(formData.getDueDate());  
        }else{
            oldBill.setDueDate(oldBill.getDueDate());
        }
        if (formData.getCategory() != null) {
            oldBill.setCategory(formData.getCategory());  
        }else{
            oldBill.setCategory(oldBill.getCategory());
        }
        
       

        return this.bills.save(oldBill);
    }


}
    

