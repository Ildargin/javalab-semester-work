package ru.itis.javalab.repositories;

import java.util.List;


public interface CrudRepository<T> {

  List<T> findAll();

  void save(T entity);

  void update(T entity);

  void deleteById(Long id);

  void delete(T entity);


}
