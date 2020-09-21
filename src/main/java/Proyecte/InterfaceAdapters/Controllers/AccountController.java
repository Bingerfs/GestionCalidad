package Proyecte.InterfaceAdapters.Controllers;

import static Proyecte.InterfaceAdapters.Utils.RequestUtil.*;

import java.util.HashMap;

import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryIn;
import Proyecte.ApplicationLogic.BoundaryGateways.AccountBoundaryOut;
import Proyecte.EnterpriseLogic.Account;
import Proyecte.InterfaceAdapters.Utils.AccountReader;
import Proyecte.InterfaceAdapters.Utils.Path;
import Proyecte.InterfaceAdapters.Utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class AccountController {
    private AccountBoundaryIn accountBoundaryIn;
    private AccountBoundaryOut accountBoundaryOut;

    public AccountController(AccountBoundaryIn accountBoundaryIn, AccountBoundaryOut accountBoundaryOut) {
        this.accountBoundaryIn = accountBoundaryIn;
        this.accountBoundaryOut = accountBoundaryOut;
    }

    public Route renderView = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.UPACCOUNTS);
    };
    
    public Route saveAccounts = (Request request, Response response) -> {
        String filepath=getfileurl(request);
        AccountReader.filename = filepath;
        AccountReader.readFile();
        for(Account account : AccountReader.accounts)
            accountBoundaryIn.createAccount(account);
        HashMap<String, Object> model = new HashMap<>();
        model = accountBoundaryOut.onSaveAccountsFromFile(accountBoundaryIn.getAccount());
        return ViewUtil.render(request, model, Path.Template.ACCOUNTS);
        };

    
}