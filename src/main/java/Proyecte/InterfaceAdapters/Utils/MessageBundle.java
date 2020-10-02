package Proyecte.InterfaceAdapters.Utils;
import java.text.*;
import java.util.*;
public class MessageBundle {
    private ResourceBundle messages;
    private MessageBundle() {
		throw new IllegalStateException("Utiliy class");
	  }
    public MessageBundle(String languageTag) {
        Locale locale = languageTag != null ? new Locale(languageTag) : Locale.ENGLISH;
        this.messages = ResourceBundle.getBundle("localization/messages", locale);
    }

    public String get(String message) {
        return messages.getString(message);
    }

    public final String get(final String key, final Object... args) {
        return MessageFormat.format(get(key), args);
    }
}
