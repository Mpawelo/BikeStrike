package bikestrike.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class BikeStrikeApp extends JFrame {

    public BikeStrikeApp() {
        super("BikeStrike");

        CardLayout card = new CardLayout();
        JPanel     root = new JPanel(card);

        Runnable goMenu      = () -> { setSize(420, 640); card.show(root, "MENU");      };
        Runnable goAddClient = () -> { setSize(720, 640); card.show(root, "ADD_CLIENT");};

        Consumer<String> fromMenuNavigate = ignored -> goAddClient.run();

        root.add(new MenuPanel(fromMenuNavigate), "MENU");
        root.add(new AddClientPanel(goMenu),      "ADD_CLIENT");

        setContentPane(root);
        goMenu.run();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(BikeStrikeApp::new);
    }
}
