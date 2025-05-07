package com.labpnc.lab2.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface iGenericRepository <T,ID> extends JpaRepository<T,ID> {
}
