package com.example.solucionreto3.services;

import com.example.solucionreto3.entities.Reservation;
import com.example.solucionreto3.entities.Skate;
import com.example.solucionreto3.repository.ReservationRepository;
import com.example.solucionreto3.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate p){
        if(p.getId()==null){
            return  skateRepository.save(p);
        }else{
            Optional<Skate> e = skateRepository.getSkate(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return  skateRepository.save(p);
            }
        }
    }

    public Skate update(Skate p) {
        if (p.getId() != null) {
            Optional<Skate> q = skateRepository.getSkate(p.getId());
            if (q.isEmpty()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
                if (p.getBrand() != null) {
                    q.get().setBrand(p.getBrand());
                }
                if (p.getYear() != null) {
                    q.get().setYear(p.getYear());
                }
                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                if (p.getCategory() != null) {
                    q.get().setCategory(p.getCategory());
                }
                if (p.getMessages() != null) {
                    q.get().setMessages(p.getMessages());
                }
                if (p.getReservations() != null) {
                    q.get().setReservations(p.getReservations());
                }
                skateRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
            boolean flag = false;
            Optional<Skate> p = skateRepository.getSkate(id);
            if (p.isPresent()) {
                skateRepository.delete(p.get());
                flag = true;
            }
            return flag;
        }

}
