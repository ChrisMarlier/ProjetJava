package BDD;

import Unite.InfanterieLegere;
import Unite.Jeep;
import Unite.Tank;
import modele.GestionMap;

import java.sql.*;


public class BDD {

    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7294456";
    String user = "sql7294456";
    String passwd = "mSBrnVA8sY";

    public BDD(GestionMap gestionMap) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            //RECUPER DATA

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from map");
            while (rs.next()){
               if(rs.getInt(1)==0){
                   System.out.println("pas de partie sauvegarder");
               }
               else{

                    Statement stmt1 = conn.createStatement();
                    ResultSet rs1 = stmt1.executeQuery("select * from J1");
                    while (rs1.next())
                    {
                        if(rs.getInt(4)==1)
                             gestionMap.getJoueur1().ajouterUnite(new InfanterieLegere(rs1.getInt(1),rs1.getInt(2),rs1.getInt(3)));
                        else if (rs1.getInt(4)==2)
                            gestionMap.getJoueur1().ajouterUnite(new Jeep(rs1.getInt(1),rs1.getInt(2),rs1.getInt(3)));
                        else if (rs1.getInt(4)==3)
                            gestionMap.getJoueur1().ajouterUnite(new Tank(rs1.getInt(1),rs1.getInt(2),rs1.getInt(3)));

                    }
                   Statement stmt2 = conn.createStatement();
                   ResultSet rs2 = stmt2.executeQuery("select * from J1");
                   while (rs2.next())
                   {
                       if(rs.getInt(4)==1)
                           gestionMap.getJoueur2().ajouterUnite(new InfanterieLegere(rs2.getInt(1),rs2.getInt(2),rs2.getInt(3)));
                       else if (rs1.getInt(4)==2)
                           gestionMap.getJoueur2().ajouterUnite(new Jeep(rs2.getInt(1),rs2.getInt(2),rs2.getInt(3)));
                       else if (rs1.getInt(4)==3)
                           gestionMap.getJoueur2().ajouterUnite(new Tank(rs2.getInt(1),rs2.getInt(2),rs2.getInt(3)));

                   }

               }
            }


            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
