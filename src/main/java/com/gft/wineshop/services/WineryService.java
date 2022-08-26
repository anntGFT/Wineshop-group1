package com.gft.wineshop.services;

import com.gft.wineshop.models.Winery;
import com.gft.wineshop.repositories.WineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryService {

    @Autowired
    private WineryRepository repository;

    public Winery findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(Exception::new);
    }

    public List<Winery> findAll() {
        return repository.findAll();
    }


    public Winery save(Winery winery) {
        return repository.save(winery);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Winery update(int id, Winery winery_new) throws Exception{
        Winery winery = findById(id);
        winery.setName(winery_new.getName());
        return repository.save(winery);
    }
}
