package Proyecte.InterfaceAdapters.Utils;
import spark.*;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

public class RequestUtil {
    public static String getQueryLocale(Request request) {
        return request.queryParams("locale");
    }

    public static String getParamIsbn(Request request) {
        return request.params("isbn");
    }

    public static String getfileurl(Request request) {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
        String file="none";
        try {
            Part filePart = request.raw().getPart("file");
            String uploadedFileName = filePart.getSubmittedFileName();
            file=uploadedFileName;
            InputStream stream = filePart.getInputStream();
            // Write stream to file under storage folder
            System.out.println("llega aqui "+uploadedFileName);
            Files.copy(stream, Paths.get("storage").resolve(uploadedFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException | ServletException e) {
            return "Exception occurred while uploading file" + e.getMessage();
        }
        return file;
        //return request.queryParams("file");
    }

    private static String downloadFile(String fileName) {
        Path filePath = Paths.get("storage").resolve(fileName);
        File file = filePath.toFile();
        if (file.exists()) {
            try {
                // Read from file and join all the lines into a string
                System.out.println("allok");
                return Files.readAllLines(filePath).stream().collect(Collectors.joining());
            } catch (IOException e) {
                return "Exception occurred while reading file" + e.getMessage();
            }
        }
        return "File doesn't exist. Cannot download";
    }
    public static String getSessionLocale(Request request) {
        return request.session().attribute("locale");
    }

    public static boolean clientAcceptsHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    public static boolean clientAcceptsJson(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("application/json");
    }
}
