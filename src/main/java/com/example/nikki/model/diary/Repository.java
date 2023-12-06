package com.example.nikki.model.diary;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository

public interface Repository extends CrudRepository<Entity,Integer> {
    @Query(value = "SELECT * FROM diary ORDER BY date DESC limit 10",nativeQuery = true)
    public List<Entity> findFirst10ByOrderByDateDesc();



}
