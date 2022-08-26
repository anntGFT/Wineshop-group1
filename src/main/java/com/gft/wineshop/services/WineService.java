package com.gft.wineshop.services;

import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Wine> findByBang(int top) {

        Page<Wine> listOfWines = repository.findAll(PageRequest.of(0, top, Sort.by("price").ascending()
                .and(Sort.by("rating").descending())));

        return listOfWines.getContent();
    }

    public Wine update(int id, Wine wine_new) {
        Wine wine = findById(id);
        wine.setName(wine_new.getName());
        wine.setYear(wine_new.getYear());
        wine.setRating(wine_new.getRating());
        wine.setNumReviews(wine_new.getNumReviews());
        wine.setPrice(wine_new.getPrice());
        wine.setBody(wine_new.getBody());
        wine.setAcidity(wine_new.getAcidity());
        wine.setWinery(wine_new.getWinery());
        wine.setType(wine_new.getType());
        wine.setRegion(wine_new.getRegion());
        return repository.save(wine);
    }
}
