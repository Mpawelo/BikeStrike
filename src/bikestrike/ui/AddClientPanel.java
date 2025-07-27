package bikestrike.ui;

import bikestrike.model.Client;
import bikestrike.service.ClientService;
import bikestrike.model.Order;

import javax.swing.*;
import java.awt.*;

class AddClientPanel extends JPanel {

    AddClientPanel(Runnable backAction) {
        setLayout(new BorderLayout(8,8));
        setBackground(new Color(173, 216, 230));

        ClientService service = new ClientService();

        JList<Client>  listClients = new JList<>(service.findAll().toArray(new Client[0]));
        JList<Order>   listOrders  = new JList<>();
        listOrders.setVisibleRowCount(10);

        listClients.addListSelectionListener(e -> {
            Client c = listClients.getSelectedValue();
            if (c != null)
                listOrders.setListData(c.getOrders().toArray(new Order[0]));
        });

        JPanel lists = new JPanel(new GridLayout(2,1,4,4));
        lists.setOpaque(false);
        lists.add(wrapWithLabel("Lista Klientów",  listClients));
        lists.add(wrapWithLabel("Zamówienia",      listOrders));

        AddClientForm form = new AddClientForm(service, backAction);
        form.setOpaque(false);

        add(form,   BorderLayout.CENTER);
        add(lists,  BorderLayout.EAST);

        service.setOnAfterSave(clients ->
                listClients.setListData(clients.toArray(new Client[0])));
    }

    private static JComponent wrapWithLabel(String txt, JComponent comp) {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel(txt, SwingConstants.CENTER), BorderLayout.NORTH);
        p.add(new JScrollPane(comp), BorderLayout.CENTER);
        return p;
    }
}
