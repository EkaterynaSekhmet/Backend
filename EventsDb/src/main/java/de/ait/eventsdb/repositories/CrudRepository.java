package de.ait.eventsdb.repositories;

import java.util.List;

public interface CrudRepository<T> {
  List<T> findAll();
}
