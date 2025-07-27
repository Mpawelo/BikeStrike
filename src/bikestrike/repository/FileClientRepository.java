package bikestrike.repository;

import bikestrike.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileClientRepository implements ClientRepository {
    private static final String FILE_NAME = "clients.dat";

    @Override
    public List<Client> findAll() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Client client) {
        List<Client> all = findAll();
        all.add(client);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}