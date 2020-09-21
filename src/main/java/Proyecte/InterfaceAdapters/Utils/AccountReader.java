package Proyecte.InterfaceAdapters.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Proyecte.EnterpriseLogic.Account;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.EnterpriseLogic.FriendsReceivable;
import Proyecte.EnterpriseLogic.Receivable;

public class AccountReader {
    public static String filename;
     public static List<Account> accounts;

     public static List<Account>readFile(){
        accounts = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("./storage/"+filename));
            String str = "";
            while ((str = in.readLine()) != null) {
                String[] accountData = str.split(", ");
                Client client = new Client(accountData[1], "ci", "address");
                List<Receivable> receivables = new ArrayList<>();
                System.out.println(accountData.length);
                if(accountData.length > 3)
                    receivables.add(new FriendsReceivable(accountData[3]));
                Account account = new Account(client, accountData[0], receivables, accountData[2]);
                accounts.add(account);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return accounts;
     }

}