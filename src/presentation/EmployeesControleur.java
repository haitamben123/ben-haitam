package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeesControleur implements IEmployeesControleur{
    @Autowired
    @Qualifier("metier")
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
