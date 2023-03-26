package jdbc;

import modele.Employees;
import java.time.LocalDateTime;
import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/masociete";
        var login = "haitam";
        var pass = "Superstar1703";
        Connection connection=null;
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList employees = new ArrayList<Employees>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("le driver de mysql a ete charge avec succes");
            connection = DriverManager.getConnection(url,login,pass);
            System.out.println("cnx etablit avec succe");
            statement = connection.createStatement();
            ps = connection.prepareStatement("select * from employee");
            rs = ps.executeQuery();
            while (rs.next())
            {
                var id = rs.getLong("id");
                var nom = rs.getString("nom");
                var prenom = rs.getString("prenom");
                var salaire = rs.getDouble("salaire");
                var annee_exp = rs.getInt("annee_exp");
                var Date_emb = rs.getString("data-emb");
                var salaire_final = rs.getDouble("salaire_final");


                Employees employee = new Employees(id,nom,prenom,salaire,annee_exp,Date_emb,salaire_final);
                employees.add(employee);




            }
            employees.forEach(System.out::println);

        } catch (ClassNotFoundException e) {
            System.out.println("Le driver du MySQL est introuvble" );
        } catch (SQLException e) {
            System.out.println("Connexion échouée");
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Connexion fermé avec succ ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'est pas fermé av succ");

            }
            try {
                if(ps != null)
                {
                    ps.close();
                    System.out.println("Connexion ferme av succ ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'a pas pu etre femrme");
            }
            try {
                if(connection != null)
                {
                    connection.close();
                    System.out.println("Connexion ffermeavec succes ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'a pas pu etre ferme");
            }


        }
    }
}