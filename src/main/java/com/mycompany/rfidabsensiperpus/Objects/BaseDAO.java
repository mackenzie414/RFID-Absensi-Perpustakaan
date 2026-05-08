/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author acer
 */
public interface BaseDAO<T> {
    void save(T entity);
    void update(Bson filter, T entity);
    void delete(Bson filter);
    
    List<T> findAll();
    T findOne(Bson filter);
    List<T> findMany(Bson filter);
}
