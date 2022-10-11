package com.usa.misiontic23.masterclass3.service;

import com.usa.misiontic23.masterclass3.entities.Product;
import com.usa.misiontic23.masterclass3.entities.Reservas;
import com.usa.misiontic23.masterclass3.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> getALL(){
        return reservasRepository.getALL();
    }
    public Optional<Reservas> getReservas(int id){
        return reservasRepository.getReservas(id);
    }
    public Reservas save(Reservas p){
        if(p.getId()==null){
            return reservasRepository.save(p);
        }else{
            Optional<Reservas> e = reservasRepository.getReservas(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return reservasRepository.save(p);
            }
        }
    }

    public Reservas update(Reservas p)
    {
        if (p.getId()!=null)
        {
            Optional<Reservas> q = reservasRepository.getReservas(p.getId());
            if(q.isPresent())
            {
                if (p.getId() != null)
                {
                    q.get().setId(p.getId());
                }
                if (p.getBox() != null)
                {
                    q.get().setBox(p.getBox());
                }
                if (p.getClient() != null)
                {
                    q.get().setClient(p.getClient());
                }

                if (p.getFechainicio() != null)
                {
                    q.get().setFechainicio(p.getFechainicio());
                }

                if (p.getFechafin() != null)
                {
                    q.get().setFechafin(p.getFechafin());
                }

                 reservasRepository.save(q.get());
                return q.get();

            } else
            {
                return p;
            }
        }else {
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservas>p= reservasRepository.getReservas(id);
        if(p.isPresent()){
            reservasRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
