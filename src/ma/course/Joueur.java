package ma.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bel3atar on 04/01/16.
 */
public class Joueur {
    public Joueur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    private int id;
    private String nom;
    public static List<Joueur> getAll() {
        List<Joueur> joueurs = new ArrayList<Joueur>();
        Statement db = BaseDeDonnées.getInstance();
        try {
            ResultSet rs  = db.executeQuery("SELECT id, nom FROM joueurs");
            while (rs.next()) joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }
    public String getNom() {
        return nom;
    }
}
