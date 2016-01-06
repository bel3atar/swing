package ma.course;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bel3atar on 04/01/16.
 */

public class NouvelleCourse extends JFrame {
    private JSpinner nPlayers;
    private JPanel root;
    private JPanel combosPanel;


    public NouvelleCourse() {
        super("NouvelleCourse");

        setContentPane(root);


        combosPanel.setLayout(new GridLayout(0, 2));
        createBoxes(2);

        pack();
        setVisible(true);

        nPlayers.addChangeListener(e -> {
            if (nPlayers.getValue() == (Object) 5) {
                nPlayers.setValue(4);
            } else if (nPlayers.getValue() == (Object) 1) {
                nPlayers.setValue(2);
            }
            createBoxes((int)nPlayers.getValue());
            pack();
        });

    }

    private void createBoxes(int n) {
        for (Component c: combosPanel.getComponents()) combosPanel.remove(c);
        for (int i = 0; i < n; ++i) {
            List<Joueur> js = Joueur.getAll();
            JComboBox j = new JComboBox(
                    js.stream()
                            .map(Joueur::getNom)
                            .collect(Collectors.toList())
                            .toArray(new String[js.size()])
            );
            List<Voiture> vs = Voiture.getAll();
            JComboBox v = new JComboBox(
                    vs.stream()
                            .map(Voiture::getNom)
                            .collect(Collectors.toList())
                            .toArray(new String[vs.size()])
            );

            combosPanel.add(j);
            combosPanel.add(v);


        }
    }

    private void createUIComponents() {
        int p = 2;
        nPlayers = new JSpinner();
        nPlayers.setValue(p);


    }

}
