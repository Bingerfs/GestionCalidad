package Proyecte.InterfaceAdapters.Utils;
import lombok.*;

public class Path {
    public static class Web {
        @Getter public static final String CALLRECORDS = "/callrecords/";
        @Getter public static final String INDEX = "/";
        @Getter public static final String CLIENTS_ALL = "/clients/";
        @Getter public static final String RCALLRECORDS = "/callrecords/rated/";
        @Getter public static final String UPACCOUNTS = "/accounts/";
        @Getter public static final String RETRIEVE = "/retrieve/";
    }

    public static class Template {
        public final static String CALLRECORDS_ALL = "/velocity/callrecords.vm";
        public final static String INDEX = "/velocity/index.vm";
        public final static String CLIENTS = "/velocity/clients.vm";
        public static final String RCALLRECORDS = "/velocity/ratedcallrecords.vm";
        public static final String ACCOUNTS = "/velocity/accounts.vm";
        public static final String UPACCOUNTS = "/velocity/uploadAccounts.vm";
        //public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}
