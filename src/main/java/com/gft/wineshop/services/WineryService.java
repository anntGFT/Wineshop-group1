package com.gft.wineshop.services;

import com.gft.wineshop.exceptions.WineryForbiddenException;
import com.gft.wineshop.exceptions.WineryNoContentException;
import com.gft.wineshop.exceptions.WineryNotFoundException;
import com.gft.wineshop.exceptions.WineryNotModifiedException;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.models.Winery;
import com.gft.wineshop.repositories.RegionRepository;
import com.gft.wineshop.repositories.WineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class WineryService {

    @Autowired
    private WineryRepository repository;

    @ExceptionHandler(value = WineryNotFoundException.class)
    public Winery findById(Integer id) throws WineryNotFoundException {
        return repository.findById(id).orElseThrow(() -> new WineryNotFoundException());
    }

    public List<Winery> findAll() throws WineryNotFoundException {
        return repository.findAll();
    }

    @ExceptionHandler({WineryForbiddenException.class, WineryNoContentException.class})
    public Winery save(Winery winery) throws WineryForbiddenException, WineryNoContentException {
        return repository.save(winery);
    }
    public void deleteById(Integer id) throws WineryNotFoundException, WineryForbiddenException {
        repository.deleteById(id);
    }

    @ExceptionHandler(value = WineryNotModifiedException.class)
    public Winery update(int id, Winery winery_new) throws WineryNotFoundException, WineryForbiddenException, WineryNotModifiedException {
        Winery winery = findById(id);
        winery.setName(winery_new.getName());
        return repository.save(winery);
    }
}
