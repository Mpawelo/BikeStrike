package bikestrike.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

class MenuPanel extends JPanel {

    MenuPanel(Consumer<String> navigate) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(173, 216, 230));

        add(Box.createVerticalStrut(40));
        JLabel title = new JLabel("Bike Strike", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(80));

        JButton btnAdd  = uiButton("Add Client");
        JButton btnExit = uiButton("Exit");

        btnAdd.addActionListener(e -> navigate.accept("ADD_CLIENT"));
        btnExit.addActionListener(e -> System.exit(0));

        add(btnAdd);
        add(Box.createVerticalStrut(20));
        add(btnExit);
    }

    private JButton uiButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.PLAIN, 18));
        b.setMaximumSize(new Dimension(200, 50));
        b.setAlignmentX(CENTER_ALIGNMENT);
        return b;
    }
}
