package bikestrike.ui;

import bikestrike.service.ClientService;

import javax.swing.*;
import java.awt.*;

class AddClientForm extends JPanel {
    private final ClientService service;
    private final Runnable backAction;

    private final JTextField tfFirst = new JTextField(12);
    private final JTextField tfLast  = new JTextField(12);
    private final JTextField tfEmail = new JTextField(12);
    private final JTextField tfPhone = new JTextField(12);
    private final JTextField tfComp  = new JTextField(12);
    private final JTextField tfNip   = new JTextField(12);

    private final JRadioButton rbInd = new JRadioButton("Individual", true);
    private final JRadioButton rbBus = new JRadioButton("Business");

    AddClientForm(ClientService service, Runnable backAction) {
        this.service     = service;
        this.backAction  = backAction;

        setLayout(new BorderLayout(8, 8));

        ButtonGroup group = new ButtonGroup();
        group.add(rbInd); group.add(rbBus);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(rbInd); top.add(rbBus);
        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4);  c.anchor = GridBagConstraints.WEST;

        int row = 0;
        addField(center, c, row++, "First name:", tfFirst);
        addField(center, c, row++, "Last name:",  tfLast);
        addField(center, c, row++, "E-mail:",     tfEmail);
        addField(center, c, row++, "Phone:",      tfPhone);
        addField(center, c, row++, "Company:",    tfComp);
        addField(center, c, row++, "NIP:",        tfNip);

        add(center, BorderLayout.CENTER);

        JButton btnAdd  = new JButton("Add");
        JButton btnBack = new JButton("Back");
        JPanel  bottom  = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        bottom.add(btnAdd); bottom.add(btnBack);
        add(bottom, BorderLayout.SOUTH);

        rbInd.addActionListener(e -> toggleBusiness(false));
        rbBus.addActionListener(e -> toggleBusiness(true));
        toggleBusiness(false);

        btnAdd.addActionListener(e -> onAdd());
        btnBack.addActionListener(e -> backAction.run());
    }


    private static void addField(JPanel p, GridBagConstraints gc, int row, String label, JComponent field) {
        gc.gridx = 0; gc.gridy = row; p.add(new JLabel(label), gc);
        gc.gridx = 1;               p.add(field, gc);
    }

    private void toggleBusiness(boolean show) {
        tfComp.setEnabled(show);
        tfNip.setEnabled(show);
        tfFirst.setEnabled(!show);
        tfLast.setEnabled(!show);
        tfPhone.setEnabled(!show);
        repaint();
    }

    private void onAdd() {
        try {
            if (rbInd.isSelected()) {
                service.addIndividualClient(
                        tfFirst.getText(), tfLast.getText(),
                        tfEmail.getText(), tfPhone.getText());
            } else {
                service.addBusinessClient(
                        tfComp.getText(), tfNip.getText(), tfEmail.getText());
            }
            JOptionPane.showMessageDialog(this, "Client added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Validation error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clear() { tfFirst.setText(""); tfLast.setText("");
        tfEmail.setText(""); tfPhone.setText(""); tfComp.setText(""); tfNip.setText(""); }
}
