package com.gft.wineshop.services;

import com.gft.wineshop.exceptions.RegionForbiddenException;
import com.gft.wineshop.exceptions.RegionNoContentException;
import com.gft.wineshop.exceptions.RegionNotFoundException;
import com.gft.wineshop.exceptions.RegionNotModifiedException;
import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository repository;

    @ExceptionHandler(value = RegionNotFoundException.class)
    public Region findById(Integer id) throws RegionNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RegionNotFoundException());
    }

    
    public List<Region> findAll() throws RegionNotFoundException {
        return repository.findAll();
    }
    
    @ExceptionHandler({RegionForbiddenException.class, RegionNoContentException.class})
    public Region save(Region region) throws RegionForbiddenException, RegionNoContentException {
        return repository.save(region);
    }

    public void deleteById(Integer id) throws RegionNotFoundException, RegionForbiddenException {
        repository.deleteById(id);
    }
    @ExceptionHandler(value = RegionNotModifiedException.class)
    public Region update(int id, Region region_new) throws RegionNotFoundException, RegionForbiddenException, RegionNotModifiedException  {
        Region region = findById(id);
        region.setName(region_new.getName());
        region.setCountry(region_new.getCountry());
        return repository.save(region);
    }
}
