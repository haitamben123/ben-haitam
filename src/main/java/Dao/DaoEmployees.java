package Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modele.Employees;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Component("Dao")
public class DaoEmployees implements IDao{
    public static Set<Employees> BDEmployees(){
        return new HashSet<Employees>(
                Arrays.asList(
                        new Employees(1L,"Benaouicha","haitam",
                                10000.0,5,"15/3/2023",0.0),
                        new Employees(2L,"Zahir","hamid",
                                10000.0,9,"15/3/2023",0.0),
                        new Employees(3L,"Cheb","laarbi",
                                10000.0,2,"15/3/2023",0.0),
                        new Employees(4L,"Pause","flow",
                                10000.0,1,"15/3/2023",0.0)
                ));
    }
    @Override
    public Employees trouverParId(Long id) {
        System.out.println("[DAO - DS volatile] trouver l'Employee n° : " + id);
        return BDEmployees().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
