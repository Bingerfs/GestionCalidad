package Proyecte.ApplicationLogic.BoundaryGateways;

import Proyecte.EnterpriseLogic.Account;

import java.util.*;

public interface AccountBoundaryOut {
    HashMap<String, Object> onSaveAccountsFromFile(List<Account> accounts);
}