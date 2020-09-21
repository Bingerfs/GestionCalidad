package Proyecte;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import Proyecte.ApplicationLogic.BoundaryGateways.IAccountRepository;
import Proyecte.ApplicationLogic.BoundaryGateways.IClientRepository;
import Proyecte.EnterpriseLogic.Account;
import Proyecte.EnterpriseLogic.Client;
import Proyecte.EnterpriseLogic.FriendsReceivable;
import Proyecte.EnterpriseLogic.Receivable;
import Proyecte.ApplicationLogic.DTOMappers.AccountDto;
import Proyecte.ApplicationLogic.DTOMappers.AccountMapper;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileAccountRepository;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileClientRepository;
import org.junit.Test;
import java.util.List;

import java.util.ArrayList;

public class AccountTest {


    @Test
    public void GetPhoneClientPrepago(){
    	Client client = new Client();
        client.address="asd";
        client.ci = "12345";
        //List<String> friends = new ArrayList<>();
        List<Receivable> receivables = new ArrayList<>();
        //IPlanClient plan2 = new PlanClientPostpago(client, "00000065", friends);
        String friends;
        friends = "79789704";
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774491", receivables, "Prepago");
        assertEquals("60774491", account.phoneNumber);
    }

    @Test
    public void ConstructorAccountPrepago(){
        Client client = new Client();
        client.address="asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        Account account1=new Account();
        account1.setClient(client);
        account1.phoneNumber="60774491";
        assertEquals("12345", account1.getClient().ci);
    }
    @Test
    public void addrecivablesAccount() {
        Client client = new Client();
        client.address = "asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        String friends;
        friends = "79789704";
        Receivable res1 = new FriendsReceivable(friends);
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774491", receivables, "Prepago");
        account.AddReceivable(res1);

        assertEquals(res1, account.getReceivables().get(1));

    }
    @Test
    public void FileAccountr() {
        Client client = new Client();
        client.address = "asd";
        client.ci = "34";
        List<Receivable> receivables = new ArrayList<>();
        String friends;
        friends = "79789704";
        Receivable res1 = new FriendsReceivable(friends);
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774492", receivables, "Prepago");
        account.AddReceivable(res1);
        IAccountRepository accountRepository = new FileAccountRepository("Accounts.txt","Receivables.txt",new FileClientRepository("clientangos.txt"));
        accountRepository.createAccount(account);
        assertEquals("Prepago", accountRepository.getAccountByPhoneNumber("60774492").accoundType);

    }
    @Test
    public void ConstructorAccountphonenumber(){
        Client client = new Client();
        client.address="asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        Account account1=new Account();
        account1.setReceivables(receivables);
        account1.setClient(client);
        account1.phoneNumber="60774491";
        account1.setPhoneNumber("60774491");
        assertEquals("60774491", account1.getPhoneNumber());
    }

    @Test
    public void addrecivablesAccountBalance_account_type() {
        Client client = new Client();
        client.address = "asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        String friends;
        friends = "79789704";
        Receivable res1 = new FriendsReceivable(friends);
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774491", receivables, "Prepago");
        account.AddReceivable(res1);
        account.setBalance("Balance");
        account.setAccountType("Prepago");
        String spect=account.getBalance()+account.getAccountType();
        assertEquals("BalancePrepago", spect);

    }
    /*@Test
    public void Accountcontroller(){
        Client client = new Client();
        client.address="asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        Account account1=new Account();
        account1.setReceivables(receivables);
        account1.setClient(client);
        account1.phoneNumber="60774491";
        account1.setPhoneNumber("60774491");
        AccountBoundaryIn accountBoundaryIn=new AccountService();
        AccountController accountController=new AccountController(accountBoundaryIn);

        assertEquals("60774491", account1.getPhoneNumber());
    }*/
    @Test
    public void accountdto() {
        AccountDto accountDto=new AccountDto("robert","312312","Balance","Prepago",null);
        assertEquals("robert", accountDto.client);

    }
    @Test
    public void accountMapper() {
        Client client = new Client();
        client.address = "asd";
        client.ci = "12345";
        List<Receivable> receivables = new ArrayList<>();
        String friends;
        friends = "79789704";
        Receivable res1 = new FriendsReceivable(friends);
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774491", receivables, "Prepago");
        AccountMapper accountMapper=new AccountMapper();
        //IClientRepository iClientRepository=new FileClientRepository("clientangos.txt");
        //AccountDto accountDto=new AccountDto("robert","312312","Balance","Prepago",null);
        //Account account=accountMapper.transformDto(accountDto,iClientRepository);
        AccountDto accountDto=accountMapper.transformAccount(account);
        assertEquals("12345", accountDto.client);

    }
    @Test
    public void accountMapper2() {
        Client client = new Client();
        client.address = "asd";
        client.ci = "12345";
        client.name="robert";
        List<Receivable> receivables = new ArrayList<>();
        String friends;
        friends = "79789704";
        //Receivable res1 = new FriendsReceivable(friends);
        receivables.add(new FriendsReceivable(friends));
        Account account = new Account(client, "60774491", receivables, "Prepago");
        AccountMapper accountMapper=new AccountMapper();
        HashMap<String, HashMap<String, Object>> data = new HashMap<>();
        for(int i=0; i<account.receivables.size(); i++)
            data.put(account.receivables.get(i).getClass().getSimpleName(), account.receivables.get(i).getData());
        IClientRepository iClientRepository=new FileClientRepository("clientangos.txt");
        AccountDto accountDto=new AccountDto("robert","312312","Balance","Prepago",data);
        Account account2=accountMapper.transformDto(accountDto,iClientRepository);
        //AccountDto accountDto=accountMapper.transformAccount(account);
        assertEquals(null, account2.client);

    }


}