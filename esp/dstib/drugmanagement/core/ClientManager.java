package esp.dstib.drugmanagement.core;

import esp.dstib.drugmanagement.model.Client;
import esp.dstib.drugmanagement.store.ClientStore;

public class ClientManager {

    private final ClientStore store;

    public ClientManager() {
        this.store = new ClientStore();
    }

    public Client createClient () throws Exception {
        Client client = new Client();
        client.setFirstName( Tools.input("Prénom(s) : ") );
        client.setLastName ( Tools.input("Nom       : ") );
        return this.store.insert(client);
    }

}
