package com.bkStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkStore.model.MyBookList;

public interface MyBookRepo extends JpaRepository<MyBookList, Integer>{

}
