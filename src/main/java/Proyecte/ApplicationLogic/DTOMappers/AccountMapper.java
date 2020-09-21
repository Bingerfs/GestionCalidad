package Proyecte.ApplicationLogic.DTOMappers;

import Proyecte.ApplicationLogic.BoundaryGateways.IClientRepository;
import Proyecte.EnterpriseLogic.Account;
import Proyecte.EnterpriseLogic.Receivable;
import Proyecte.EnterpriseLogic.ReceivableFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class AccountMapper {
    public Account transformDto(AccountDto data, IClientRepository clientRepository){
        List<Receivable> receivables = new ArrayList<>();
        for (Entry<String, HashMap<String,Object>> entry : data.receivables.entrySet()) {
            Receivable receivable;
            receivable = ReceivableFactory.getReceivable(entry.getKey(), entry.getValue());
            receivables.add(receivable);
        }
        return new Account(clientRepository.getClientByCi(data.client), data.phoneNumber, receivables, data.accoundType);
    }

    public AccountDto transformAccount(Account account){
        HashMap<String, HashMap<String, Object>> data = new HashMap<>();
        for(int i=0; i<account.receivables.size(); i++)
            data.put(account.receivables.get(i).getClass().getSimpleName(), account.receivables.get(i).getData());
        

        return new AccountDto(account.client.ci, account.phoneNumber, account.balance, account.accoundType, data);
    }
}