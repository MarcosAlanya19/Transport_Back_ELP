package com.transport.management.utils.abtractBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends CrudRepository<T, Long> {}
