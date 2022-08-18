package com.familyapp.reservation;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

    private ReservationRepository reservations;

    public ReservationService(ReservationRepository rr) {
        super();
        this.reservations = rr;
    }

    @Override
    public Reservation findById(long id){
        try {
            return this.reservations.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Reservation> findAll(){
        return this.reservations.findAll();
    }

    @Override
    public boolean delete(long id){
        Reservation r = this.findById(id);
        try {
            this.reservations.delete(r);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Reservation create(Reservation r){
        r = this.reservations.save(r);
        return r;
    }

    

    @Override
    public Reservation update(Long id, Reservation formData){
        Reservation oldReservation = this.findById(id);
        if(oldReservation == null){
            return null;
        }
        if (formData.getDateStart() != null) {
            oldReservation.setDateStart(formData.getDateStart());  
        }else{
            oldReservation.setDateStart(oldReservation.getDateStart());
        }
        if (formData.getDateFinish() != null) {
            oldReservation.setDateFinish(formData.getDateFinish());  
        }else{
            oldReservation.setDateFinish(oldReservation.getDateFinish());
        }
        
        if (formData.getCarId().equals(null)) {
            oldReservation.setCarId(oldReservation.getCarId());
        }else{
            oldReservation.setCarId(formData.getCarId());  
        }
        if (formData.getUser().equals(null)) {
            oldReservation.setUser(oldReservation.getUser());
        }else{
            oldReservation.setUser(formData.getUser());  
        }
           
       return this.reservations.save(oldReservation);
    }


}
    

