package game;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public List<ClientData> clientDataList = new ArrayList<ClientData>();

    public void addClient(ClientData clientData){
        clientDataList.add(clientData);
    }
    public void addClient(String name, String lastName, String emailAddress, long phoneNumber){
        ClientData tmp = new ClientData(name, lastName, emailAddress, phoneNumber);
        clientDataList.add(tmp);
    }




}
