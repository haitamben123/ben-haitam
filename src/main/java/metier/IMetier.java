package metier;

import modele.Employees;

public interface IMetier {
    Employees calculer_SalaireFinal(Long idemp) throws Exception;
}
