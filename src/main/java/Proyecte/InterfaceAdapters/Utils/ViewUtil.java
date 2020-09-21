package Proyecte.InterfaceAdapters.Utils;
import org.apache.velocity.app.*;
import org.eclipse.jetty.http.*;
import spark.*;
import spark.template.velocity.*;

import java.util.*;
import static Proyecte.InterfaceAdapters.Utils.RequestUtil.*;

public class ViewUtil {

    public static String render(Request request, Map<String, Object> model, String templatePath) {
        model.put("msg", new MessageBundle(getSessionLocale(request)));
         /*model.put("currentUser", getSessionCurrentUser(request));*/
        model.put("WebPath", Path.Web.class); // Access application URLs from templates
        return strictVelocityEngine().render(new ModelAndView(model, templatePath));
    }

    public static Route notAcceptable = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_ACCEPTABLE_406);
        return new MessageBundle(getSessionLocale(request)).get("ERROR_406_NOT_ACCEPTABLE");
    };

    private static VelocityTemplateEngine strictVelocityEngine() {
        VelocityEngine configuredEngine = new VelocityEngine();
        configuredEngine.setProperty("runtime.references.strict", true);
        configuredEngine.setProperty("resource.loader", "class");
        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(configuredEngine);
    }
}
