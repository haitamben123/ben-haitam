import Dao.DaoEmployees;
import Dao.IDao;
import metier.EmployeesMetier;
import metier.IMetier;
import modele.Employees;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import presentation.EmployeesControleur;
import presentation.IEmployeesControleur;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class SimulateurDeMaSosiete {
    static Scanner clavier = new Scanner(System.in);
    static IEmployeesControleur employeesControleur;

    private static boolean estUnNombre(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void test1 (){
        var dao = new DaoEmployees();
        var metier = new EmployeesMetier();
        var controleur = new EmployeesControleur();

        metier.setEmployeesdao(dao);
        controleur.setEmployeeMetier(metier);
        String rep = "";
        do {
            System.out.println("=> [Test 1] calculer le salaire de l'employee <=\n");
            try {
                String input = "";
                while (true) {
                    System.out.println("=> Entrer l'id du Employee : ");
                    input = clavier.nextLine();
                    if (estUnNombre(input)) break;
                    System.err.println("Entree non valide !!");
                }
                Long id = Long.parseLong(input);
                controleur.afficher_Salaire_Final(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quittez(oui/non) ? ");
            rep = clavier.nextLine();
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println(" Au revoir ^_^");

    }
    public static void test2() throws Exception {
        String daoClass ;
        String serviceClass;
        String controllerClass;

        Properties properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("config.properties");

        if(propertiesFile == null) throw new Exception("fichier config introuvable !!!");
        else{
            try {
                properties.load(propertiesFile);
                daoClass = properties.getProperty("DAO");
                serviceClass = properties.getProperty("SERVICE");
                controllerClass = properties.getProperty("CONTROLLER");
                propertiesFile.close();
            }
            catch (IOException e){
                throw new Exception("Probléme de changement des propriete du fichier config");
            }
            finally {
                properties.clear();
            }
        }

        try {
            Class cDao = Class.forName(daoClass);
            Class cMetier = Class.forName(serviceClass);
            Class cControleur = Class.forName(controllerClass);

            var dao = (IDao<Employees,Long>) cDao.getDeclaredConstructor().newInstance();
            var metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
            var employeesControleur = (IEmployeesControleur) cControleur.getDeclaredConstructor().newInstance();

            Method setDao = cMetier.getMethod("setEmployeesdao",IDao.class);
            setDao.invoke(metier,dao);
            Method setMetier = cControleur.getMethod("setEmployeeMetier", IMetier.class);
            setMetier.invoke(employeesControleur,metier);
            String rep = "";
            do {
                System.out.println("=> [Test 2] calculer le salaire de l'employee <=\n");
                try {
                    String input = "";
                    while (true) {
                        System.out.println("=> Entrer l'id du Employee : ");
                        input = clavier.nextLine();
                        if (estUnNombre(input)) break;
                        System.err.println("Entree non valide !!");
                    }
                    Long id = Long.parseLong(input);
                    employeesControleur.afficher_Salaire_Final(id);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("Voulez vous quittez(oui/non) ? ");
                rep = clavier.nextLine();
            }while (!rep.equalsIgnoreCase("oui"));
            System.out.println(" Au revoir ^_^");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void test4() throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext("Dao","metier","presentation");
        employeesControleur  = (EmployeesControleur) context.getBean(IEmployeesControleur.class);
        String rep = "";
        do {
            System.out.println("=> [Test 4] calculer le salaire de l'employee <=\n");
            try {
                String input = "";
                while (true) {
                    System.out.println("=> Entrer l'id du Employee : ");
                    input = clavier.nextLine();
                    if (estUnNombre(input)) break;
                    System.err.println("Entree non valide !!");
                }
                Long id = Long.parseLong(input);
                employeesControleur.afficher_Salaire_Final(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quittez(oui/non) ? ");
            rep = clavier.nextLine();
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println(" Au revoir ^_^");


    }
    public static void main(String[] args) throws Exception {
        test2();
    }

}
