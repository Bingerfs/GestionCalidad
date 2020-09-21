package Proyecte.ApplicationLogic.UseCases;

import java.util.List;

import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.IAccountRepository;
import Proyecte.EnterpriseLogic.Account;

public class AccountService implements AccountBoundaryIn {
    private IAccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        accountRepository.createAccount(account);
    }

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccount() {
        return this.accountRepository.getAccounts();
    }

    
    
}