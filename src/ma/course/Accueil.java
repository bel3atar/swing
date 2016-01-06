package ma.course;




import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by bel3atar on 04/01/16.
 */
public class Accueil {
    private JButton résultatsButton;
    private JButton lancerUneNouvelleCourseButton;
    private JPanel root;
    private static Statement db;

    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Accueil");
            frame.setContentPane(new Accueil().root);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        });

    }

    public Accueil() {
        résultatsButton.addActionListener(e -> {
            JFrame f = new JFrame("Resultats");
            f.setContentPane(new Resultats().getRoot());
            f.pack();
            f.setVisible(true);
        });
        lancerUneNouvelleCourseButton.addActionListener(e -> {
            JFrame f = new NouvelleCourse();
        });
    }

}
