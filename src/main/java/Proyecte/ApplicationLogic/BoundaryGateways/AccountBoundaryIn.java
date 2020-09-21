package Proyecte.ApplicationLogic.BoundaryGateways;

import java.util.List;

import Proyecte.EnterpriseLogic.Account;

public interface AccountBoundaryIn {
    void createAccount(Account account);
    List<Account> getAccount();
}