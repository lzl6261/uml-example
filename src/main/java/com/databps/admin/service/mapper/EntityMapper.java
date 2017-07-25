package com.databps.admin.service.mapper;

import java.util.List;

/**
 * @author merlin
 * @create 2017-07-26 上午1:17
 */

public interface EntityMapper <V, E> {

  public E toEntity(V dto);

  public V toVO(E entity);

  public List<E> toEntity(List<V> dtoList);

  public List <V> toVO(List<E> entityList);
}
