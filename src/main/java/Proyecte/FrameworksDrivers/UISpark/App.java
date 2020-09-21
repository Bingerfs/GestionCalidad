package Proyecte.FrameworksDrivers.UISpark;

import Proyecte.ApplicationLogic.BoundaryGateways.ICDRRepository;
import Proyecte.ApplicationLogic.UseCases.AccountService;
import Proyecte.ApplicationLogic.UseCases.CallRecordService;
import Proyecte.ApplicationLogic.UseCases.ClientService;
import Proyecte.ApplicationLogic.UseCases.RestService;
import Proyecte.EnterpriseLogic.CallRecord;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileAccountRepository;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileCDRRepository;
import Proyecte.InterfaceAdapters.GatewayImpl.File.FileClientRepository;
import Proyecte.InterfaceAdapters.GatewayImpl.SQL.SqlClientRepository;
import Proyecte.InterfaceAdapters.Presenters.AccountPresenter;
import Proyecte.InterfaceAdapters.Presenters.CallRecordPresenter;
import Proyecte.InterfaceAdapters.Presenters.ClientPresenter;
import Proyecte.InterfaceAdapters.Controllers.*;
import Proyecte.InterfaceAdapters.Presenters.RestPresenter;
import Proyecte.InterfaceAdapters.Utils.CRReader;
import Proyecte.InterfaceAdapters.Utils.Path;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;
/**
 * Hello world!
 *
 */
public class App 
{

    public static List<CallRecord> callRecordList=new ArrayList<>();
    public static UIController uiController=new UIController();
    public static ClientController clientController = new ClientController(new ClientService(new FileClientRepository("clientangos.txt"), new ClientPresenter()));
   public static ICDRRepository icdrRepository=new FileCDRRepository();
    public static CallRecordController callRecordController = new CallRecordController(new CallRecordService(new FileCDRRepository("Records.txt")), new CallRecordPresenter());
    public static AccountController accountController = new AccountController(new AccountService(new FileAccountRepository("Accounts.txt", "Receivables.txt", new FileClientRepository("clientangos.txt"))),
            new AccountPresenter());
    public static RestController restController = new RestController(new RestService(new FileCDRRepository("Records.txt")), new RestPresenter());
    
    public static void main(String[] args) {
        File storageDir = new File("storage");
        if (!storageDir.isDirectory()) storageDir.mkdir();
        System.out.println("file name "+ CRReader.filename);

        port(4567);

        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();
        
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

       // get(Path.Web.CALLRECORDS,    uiController.fetchAllBooks);
        get(Path.Web.INDEX,    uiController.index);
        get(Path.Web.CLIENTS_ALL,   clientController.getAllClients);
        get(Path.Web.CALLRECORDS,   callRecordController.getAllCallRecords);
        post(Path.Web.INDEX,callRecordController.getfileCallrecords);
        get(Path.Web.RCALLRECORDS, callRecordController.rateUploadedRecords);
        post(Path.Web.CALLRECORDS, callRecordController.saveCdrList);
        get(Path.Web.UPACCOUNTS, accountController.renderView);
        post(Path.Web.UPACCOUNTS, accountController.saveAccounts);
        get(Path.Web.RETRIEVE, restController.getRecordsByPhoneNumber);
        //get("*",                     ViewUtil.notFound);

        after("*",                   Filters.addGzipHeader);
        enableCORS("*", "*", "*");


        
    }

    private static void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {
    
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
    
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
    
            return "OK";
        });
    
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
        });
    }
}
