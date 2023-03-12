package metier;

import Dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modele.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class EmployeesMetier implements IMetier{
    @Autowired
    @Qualifier("Dao")

    IDao<Employees,Long> employeesdao;

    @Override
    public Employees calculer_SalaireFinal(Long idemp) throws Exception {
        var employees = employeesdao.trouverParId(idemp);
        if (employees == null) throw new Exception("L'id du L'Employee est incorrect :: [Employee non trouvé]");
        else {
            double salaire = employees.getSalaire();
            int annee_exp = employees.getAnnee_experience();

            double salaire_final = 0.0;
            if (annee_exp <= 2) {
                salaire_final = salaire;
            } else if (annee_exp <= 5 && annee_exp > 2) {
                salaire_final = salaire * 1.5;
            } else if (annee_exp > 5) {
                salaire_final = salaire * 2;
            }

            employees.setSalaire_final(salaire_final);
            return employees;
        }
    }

    public void setEmployeesdao(IDao<Employees, Long> employeesdao) {
        this.employeesdao = employeesdao;
    }
}
