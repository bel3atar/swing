package ma.course;




import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by bel3atar on 04/01/16.
 */
public class BaseDeDonnées {
    private static final String CHEMIN_BASE = "db/db";
    private static Connection c = null;
    private static Statement s = null;
    private BaseDeDonnées() {}
    public static Statement getInstance() {
        if (s == null)
            try {
                Class.forName("org.sqlite.JDBC");
                s = DriverManager.getConnection("jdbc:sqlite:" + CHEMIN_BASE).createStatement();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame("Err"), "Erreur", e.toString(), JOptionPane.ERROR_MESSAGE);
            }
        return s;
    }
}
