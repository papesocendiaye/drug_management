package esp.dstib.drugmanagement.core;
import esp.dstib.drugmanagement.model.Client;
import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.model.Order;
import esp.dstib.drugmanagement.store.ClientStore;
import esp.dstib.drugmanagement.store.OrderStore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
    
    
    public class OrderManagement {
        private final OrderStore orderStore;
        private final ClientManager clientManager;
        private final Employe connectedEmploye;
        public OrderManagement( Employe employe ) {
            this.clientManager = new ClientManager();
            this.orderStore = new OrderStore();
            this.connectedEmploye = employe;
        }
    
        public Order createOrder () throws Exception {
    
            Date date_order = new Date();
            Client new_client = clientManager.createClient();

            Order order = new Order(date_order, new_client, connectedEmploye );
            try {
                return this.orderStore.insert(order);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        }
//
//        public void modifyOrder() {
//             String date_order =  Tools.input("Veuillez donner la date de la commande  : ");
//        try {
//            List<Order> orders = this.orderStore.selectByKey("titre", date_order);
//            Tools.printOrderList(orders);
//            String orderId = Tools.input("Saisissez l'id correspondant: ");
//            Order order = this.orderStore.select(Integer.parseInt(orderId));
//            Tools.printOrder(order);
//            Tools.print( "1 - Date" );
//            Tools.print( "2 - Montant" );
//            Tools.print( "3 - Client" );
//            Tools.print( "4 - Employé" );
//            Tools.print( "5 - Les quatre " );
//            String choice = Tools.input("Choix: ");
//            switch (choice)  {
//                case "1":
//                    String newDate_order = Tools.input("Veuillez saisir la nouvelle date: ");
//                    Date date_order_ = (Date) new SimpleDateFormat("jj/mm/aaaa").parse(newDate_order);
//                    order.setDate(date_order_);
//                    this.orderStore.update(order);
//                    break;
//                case "2":
//                    String newAmountorder = Tools.input("Veuillez saisir le nouveau montant: ");
//                    Float newAmount_order = Float.parseFloat(newAmountorder);
//                    order.setAmount(newAmount_order);
//                    this.orderStore.update(order);
//                    break;
//
//                case "3":
//                    String newClientorder = Tools.input("Veuillez saisir le nouveau client: ");
//                    int client_order_ = Integer.parseInt(newClientorder);
//                    Client newclient_order = new Client(client_order_);
//                    order.setClient(newclient_order);
//                    this.orderStore.update(order);
//                    break;
//
//                case "4":
//                    String newEmployeorder = Tools.input("Veuillez saisir le nouveau employé: ");
//                    int employe_order_ = Integer.parseInt(newEmployeorder);
//                    Client newemploye_order = new Client(employe_order_);
//                    order.setClient(newemploye_order);
//                    this.orderStore.update(order);
//                    break;
//
//                case "5":
//                    Tools.print("Demande à SOKHNA GNING ");
//                    break;
//            }
//            Tools.printOrder(order);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
    public void removeOrder() {
        String id = Tools.input("Veuillez saisir l'identifiant de la commande  que vous souhaitez supprimer : ");
            int idd =Integer.parseInt(id);
            try{
                orderStore.delete(idd);
                Tools.print(id + " a été supprimé");
            }catch (Exception e){
                Tools.print("Erreur lors de la supression de "+id+".\nCause :"+e.getMessage());
            }
    }
    
}
