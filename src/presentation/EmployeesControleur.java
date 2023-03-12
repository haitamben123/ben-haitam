package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import metier.IMetier;
@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeesControleur implements IEmployeesControleur{
    IMetier employeeMetier;
    @Override
    public void afficher_Salaire_Final(Long idemp) throws Exception {
        var EmployeeAvecSalaire = employeeMetier.calculer_SalaireFinal(idemp);
        System.out.println(EmployeeAvecSalaire);
    }

    public void setEmployeeMetier(IMetier employeeMetier) {
        this.employeeMetier = employeeMetier;
    }
}
