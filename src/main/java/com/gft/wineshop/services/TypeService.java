package com.gft.wineshop.services;

import com.gft.wineshop.exceptions.TypeForbiddenException;
import com.gft.wineshop.exceptions.TypeNoContentException;
import com.gft.wineshop.exceptions.TypeNotFoundException;
import com.gft.wineshop.exceptions.TypeNotModifiedException;
import com.gft.wineshop.models.Type;
import com.gft.wineshop.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    @ExceptionHandler(value = TypeNotFoundException.class)
    public Type findById(Integer id) throws TypeNotFoundException {
        return repository.findById(id).orElseThrow(() -> new TypeNotFoundException());
    }
    
    public List<Type> findAll() throws TypeNotFoundException {
        return repository.findAll();
    }
 
    @ExceptionHandler({TypeForbiddenException.class, TypeNoContentException.class})
    public Type save(Type type) throws TypeForbiddenException, TypeNoContentException {
        return repository.save(type);
    }

    public void deleteById(Integer id) throws TypeNotFoundException, TypeForbiddenException {
        repository.deleteById(id);
    }
    @ExceptionHandler(value = TypeNotModifiedException.class)
    public Type update(int id, Type type_new) throws TypeNotFoundException, TypeForbiddenException, TypeNotModifiedException {
        Type type = findById(id);
        type.setName(type_new.getName());
        return repository.save(type);
    }
}
