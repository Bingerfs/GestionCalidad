package Proyecte.EnterpriseLogic;

import java.util.List;

public class Account {
    public Client client;
    public String phoneNumber;
    public String balance;
    public String accoundType;
    public List<Receivable> receivables;

    public Account(){
        
    }

    public Account(Client client, String phoneNumber, List<Receivable> receivables, String accountType) {
        this.client = client;
        this.phoneNumber = phoneNumber;
        this.receivables = receivables;
        this.accoundType = accountType;
        this.balance = "0";
    }

    public void AddReceivable(Receivable receivable){
        receivables.add(receivable);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<Receivable> getReceivables() {
        return receivables;
    }

    public void setReceivables(List<Receivable> receivables) {
        this.receivables = receivables;
    }

    public void setAccountType(String accountType){
        this.accoundType = accountType;
    }

    public String getAccountType(){
        return accoundType;
    }

    public String getClientName(){
        return client.name;
    }

    
    

    


    
}