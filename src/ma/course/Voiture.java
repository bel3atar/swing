package ma.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bel3atar on 04/01/16.
 */
public class Voiture {
    private int id;
    private String nom;

    public String getNom() {
        return nom;
    }

    public Voiture(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }



    public static List<Voiture> getAll() {
        List<Voiture> joueurs = new ArrayList<Voiture>();
        Statement db = BaseDeDonnées.getInstance();
        try {
            ResultSet rs  = db.executeQuery("SELECT id, nom FROM voitures");
            while (rs.next()) joueurs.add(new Voiture(rs.getInt("id"), rs.getString("nom")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }

}
