package bikestrike.repository;

import bikestrike.model.Client;
import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
    void save(Client client);
}
