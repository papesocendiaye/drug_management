package esp.dstib.drugmanagement.core;
import esp.dstib.drugmanagement.enums.EnumTypeEmploye;
import esp.dstib.drugmanagement.model.Client;
import esp.dstib.drugmanagement.model.Drug;
import esp.dstib.drugmanagement.model.DrugOrder;
import esp.dstib.drugmanagement.model.Employe;
import esp.dstib.drugmanagement.model.Order;
import esp.dstib.drugmanagement.store.OrderStore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
    
    
    public class OrderManagement {
        private final OrderStore orderStore;
        public OrderManagement() {
            this.orderStore = new OrderStore();
        }
    
        public Order createOrder () throws ParseException {
    
            String date_ =  Tools.input("Veuillez saisir la date de la commande  : ");
            Date date_order = (Date) new SimpleDateFormat("jj/mm/aaaa").parse(date_);
            String amount_ =  Tools.input("Donner le montant de la commande   : ");
            float amount_order = Float.parseFloat(amount_);
            String client_ =  Tools.input("L'id du client    : ");
            int client_order_ = Integer.parseInt(client_);
            Client client_order = new Client(client_order_);
            String employe_ =  Tools.input("L'id de l'employé   : ");
            int employe_id = Integer.parseInt(employe_);
            Employe employe =  new Employe(employe_id);
            /*String employe_prenom =  Tools.input("Le prénom de l'employé   : ");
            String employe_nom =  Tools.input("Le nom de l'employé   : ");
            String employe_type =  Tools.input("Le type de l'employé   : ");
            EnumTypeEmploye enumTypeEmploye = EnumTypeEmploye.valueOf(employe_type);
            Employe employe =  new Employe(employe_id, employe_prenom, employe_nom, enumTypeEmploye);
            String drugOrders_ =  Tools.input("La liste des medicaments  : ");
            List<DrugOrder> drugorder = new ArrayList<>(List.of(drugOrders_));
            List<String> drugOrders = List.of(drugOrders_.split(","));
            */
            Order order = new Order(date_order, amount_order, client_order, employe);
            try {
                return this.orderStore.insert(order);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        }
    
        public void modifyOrder() {
             String date_order =  Tools.input("Veuillez donner la date de la commande  : ");
        try {
            List<Order> orders = this.orderStore.selectByKey("titre", date_order);
            Tools.printOrderList(orders);
            String orderId = Tools.input("Saisissez l'id correspondant: ");
            Order order = this.orderStore.select(Integer.parseInt(orderId));
            Tools.printOrder(order);
            Tools.print( "1 - Date" );
            Tools.print( "2 - Montant" );
            Tools.print( "3 - Client" );
            Tools.print( "4 - Employé" );
            Tools.print( "5 - Les quatre " );
            String choice = Tools.input("Choix: ");
            switch (choice)  {
                case "1":
                    String newDate_order = Tools.input("Veuillez saisir la nouvelle date: ");
                    Date date_order_ = (Date) new SimpleDateFormat("jj/mm/aaaa").parse(newDate_order);
                    order.setDate(date_order_);
                    this.orderStore.update(order);
                    break;
                case "2":
                    String newAmountorder = Tools.input("Veuillez saisir le nouveau montant: ");
                    Float newAmount_order = Float.parseFloat(newAmountorder);
                    order.setAmount(newAmount_order);
                    this.orderStore.update(order);
                    break;
                
                case "3":
                    String newClientorder = Tools.input("Veuillez saisir le nouveau client: ");
                    int client_order_ = Integer.parseInt(newClientorder);
                    Client newclient_order = new Client(client_order_);
                    order.setClient(newclient_order);
                    this.orderStore.update(order);
                    break;
                
                case "4":
                    String newEmployeorder = Tools.input("Veuillez saisir le nouveau employé: ");
                    int employe_order_ = Integer.parseInt(newEmployeorder);
                    Client newemploye_order = new Client(employe_order_);
                    order.setClient(newemploye_order);
                    this.orderStore.update(order);
                    break;
                
                case "5":
                    Tools.print("Demande à SOKHNA GNING ");
                    break;
            }
            Tools.printOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
           
             
    }
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
