package Dao;

import modele.Employees;

public interface IDao <T, ID>{
    Employees trouverParId (Long id);
}
