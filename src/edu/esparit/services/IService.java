/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esparit.services;

import java.util.List;

/**
 *
 * @author attia
 */
public interface IService <T> {
    public void ajouter(T p);
    public void supprimer(int id);
    public void modifier(T p);
    public List<T> getAll();
    public T getTbyId(int id);
  
    
}
