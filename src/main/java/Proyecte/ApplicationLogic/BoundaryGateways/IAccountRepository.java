package Proyecte.ApplicationLogic.BoundaryGateways;

import java.util.List;

import Proyecte.EnterpriseLogic.Account;

public interface IAccountRepository {
    Account getAccountByPhoneNumber(String phoneNumber);
    void createAccount(Account account);
    List<Account> getAccounts();
}