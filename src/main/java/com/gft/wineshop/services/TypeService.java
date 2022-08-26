package com.gft.wineshop.services;

import com.gft.wineshop.models.Type;
import com.gft.wineshop.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public Type findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(Exception::new);
    }

    public List<Type> findAll() {
        return repository.findAll();
    }


    public Type save(Type type) {
        return repository.save(type);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Type update(int id, Type type_new) throws Exception{
        Type type = findById(id);
        type.setName(type_new.getName());
        return repository.save(type);
    }
}
