package bikestrike.service;

import bikestrike.model.BusinessClient;
import bikestrike.model.Client;
import bikestrike.model.IndividualClient;
import bikestrike.model.Order;
import bikestrike.repository.ClientRepository;
import bikestrike.repository.FileClientRepository;
import bikestrike.util.ValidationUtil;

import java.util.List;
import java.util.function.Consumer;


public class ClientService {

    private final ClientRepository repo;

    private Consumer<List<Client>> afterSave = clients -> { };


    public ClientService() {
        this.repo = new FileClientRepository();
        for (Client c : repo.findAll()) {
            if (c.getOrders().isEmpty()) {
                c.getOrders().add(new Order());
                c.getOrders().add(new Order());
                repo.save(c);
            }
        }

    }

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }


    public void addIndividualClient(String firstName,
                                    String lastName,
                                    String email,
                                    String phone) {

        ValidationUtil.requireEmail(email);
        if (existsByEmail(email)) {
            throw new IllegalArgumentException("Client with this e-mail already exists");
        }

        IndividualClient c = new IndividualClient();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setPhoneNumber(phone);

        addClient(c);
    }

    public void addBusinessClient(String companyName,
                                  String nip,
                                  String email) {

        ValidationUtil.requireEmail(email);
        ValidationUtil.requireNip(nip);
        if (existsByNip(nip)) {
            throw new IllegalArgumentException("Client with this NIP already exists");
        }

        BusinessClient c = new BusinessClient();
        c.setCompanyName(companyName);
        c.setNip(nip);
        c.setEmail(email);

        addClient(c);
    }

    public void addClient(Client client) {
        if (client == null) throw new IllegalArgumentException("Client cannot be null");

        if (existsByEmail(client.getEmail()))
            throw new IllegalArgumentException("A client with the same e-mail already exists!");
        if (client instanceof BusinessClient bc && bc.getNip() != null && existsByNip(bc.getNip()))
            throw new IllegalArgumentException("A client with the same NIP already exists!");

        ValidationUtil.requireEmail(client.getEmail());

        if (client.getOrders().isEmpty())
            client.getOrders().add(new Order());
        repo.save(client);

        afterSave.accept(repo.findAll());
    }


    public List<Client> listClients(){ return repo.findAll(); }
    public List<Client> findAll(){ return repo.findAll(); }

    private boolean existsByEmail(String email)  {
        return repo.findAll().stream()
                .anyMatch(c -> email.equalsIgnoreCase(c.getEmail()));
    }
    private boolean existsByNip(String nip)      {
        return repo.findAll().stream()
                .filter(BusinessClient.class::isInstance)
                .map(BusinessClient.class::cast)
                .anyMatch(bc -> nip.equalsIgnoreCase(bc.getNip()));
    }

    public void setOnAfterSave(Consumer<List<Client>> listener) {
        if (listener != null) this.afterSave = listener;
    }
}
