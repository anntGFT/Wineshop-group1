package com.gft.wineshop.services;

import com.gft.wineshop.models.Region;
import com.gft.wineshop.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository repository;

    public Region findById(Integer id) throws Exception{
        return repository.findById(id).orElseThrow(Exception::new);
    }

    public List<Region> findAll() {
        return repository.findAll();
    }

    public Region save(Region region) {
        return repository.save(region);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Region update(int id, Region region_new) throws Exception{
        Region region = findById(id);
        region.setName(region_new.getName());
        region.setCountry(region_new.getCountry());
        return repository.save(region);
    }
}
