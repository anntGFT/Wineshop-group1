package com.gft.wineshop.services;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.RegionRepository;
import com.gft.wineshop.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository repository;

    public Wine findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Wine> findAll() {
        return repository.findAll();
    }

    public Wine save(Wine wine) {
        return repository.save(wine);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Wine update(int id, Wine wine_new) {
        Wine wine = findById(id);
        wine.setName(wine_new.getName());
        wine.setYear(wine_new.getYear());
        wine.setRating(wine_new.getRating());
        wine.setNum_reviews(wine_new.getNum_reviews());
        wine.setPrice(wine_new.getPrice());
        wine.setBody(wine_new.getBody());
        wine.setAcidity(wine_new.getAcidity());
        wine.setWinery(wine_new.getWinery());
        wine.setType(wine_new.getType());
        wine.setRegion(wine_new.getRegion());
        return repository.save(wine);
    }
}
