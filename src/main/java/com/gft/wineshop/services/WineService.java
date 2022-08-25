package com.gft.wineshop.services;

import com.gft.wineshop.exceptions.WineForbiddenException;
import com.gft.wineshop.exceptions.WineNoContentException;
import com.gft.wineshop.exceptions.WineNotFoundException;
import com.gft.wineshop.exceptions.WineNotModifiedException;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.models.Wine;
import com.gft.wineshop.repositories.RegionRepository;
import com.gft.wineshop.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository repository;

    @ExceptionHandler(value = WineNotFoundException.class)
    public Wine findById(Integer id) throws WineNotFoundException {
        return repository.findById(id).orElseThrow(() -> new WineNotFoundException());
    }

    public List<Wine> findAll() throws WineNotFoundException {
        return repository.findAll();
    }

    @ExceptionHandler({WineForbiddenException.class, WineNoContentException.class})
    public Wine save(Wine wine) throws WineForbiddenException, WineNoContentException {
        return repository.save(wine);
    }
    
    public void deleteById(Integer id) throws WineNotFoundException, WineForbiddenException, WineNotModifiedException {
        repository.deleteById(id);
    }

    @ExceptionHandler(value = WineNotModifiedException.class)
    public Wine update(int id, Wine wine_new) throws WineNotFoundException, WineForbiddenException, WineNotModifiedException  {
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
