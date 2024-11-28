package com.transport.management.utils.abtractBase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> {
  @Autowired
  private BaseRepository<T> repositoryBase;

  public List<T> findAll() {
    List<T> T = (List<T>) repositoryBase.findAll();
    return T;
  }

  public T findById(Long id) {
    Optional<T> optional = repositoryBase.findById(id);
    return optional.orElse(null);
  }

  public T save(T Object) {
    return repositoryBase.save(Object);
  }

  public boolean deleteById(Long id) {
    Optional<T> optionalStudent = repositoryBase.findById(id);
    if (optionalStudent.isPresent()) {
      repositoryBase.delete(optionalStudent.get());
      return true;
    }
    return false;
  }
}
