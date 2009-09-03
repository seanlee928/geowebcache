package org.geowebcache.mime;

public class TextMime extends MimeType {

    public static final TextMime txt = new TextMime(
       "text/plain", "txt", "txt",
       "text/plain", true);
    
    public static final TextMime txtHtml = new TextMime(
            "text/html", "txt.html", "html",
            "text/html", true);
        
    private TextMime(String mimeType, String fileExtension, 
            String internalName, String format, boolean noop) {
        super(mimeType, fileExtension, internalName, format, false);
    }
    
    protected static TextMime checkForFormat(String formatStr) throws MimeException {
        if(formatStr.toLowerCase().startsWith("text")) {
            if(formatStr.equalsIgnoreCase("text/plain")) {
                return txt;
            } else if(formatStr.startsWith("text/html")) {
                return txtHtml;
            }
        }
        
        return null;
    }
    
    protected static TextMime checkForExtension(String fileExtension) throws MimeException {
        if(fileExtension.equalsIgnoreCase("txt")) {
            return txt;
        } else if(fileExtension.equalsIgnoreCase("txt.html")) {
            return txtHtml;
        }
        
        return null;
    }
}
