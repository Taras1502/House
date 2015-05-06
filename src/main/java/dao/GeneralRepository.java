package dao;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 06.05.2015.
 */

public interface GeneralRepository<E> {

    int add(E entity);

    boolean update(E entity);

    boolean remove(int id);

    E findById(int id);

    List<E> findAll(int lastId, int amount);

}

