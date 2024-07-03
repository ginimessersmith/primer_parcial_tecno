package utils;

public class Extractor {
    private static String GMAIL = "d=gmail";
    private static String HOTMAIL = "d=hotmail";
    private static String YAHOO = "d=yahoo";
    
    public static Email getEmail(String plain_text) {
        return new Email(getFrom(plain_text), getSubject(plain_text));
    }
    
    private static String getFrom(String plain_text) {
        String search = "Return-Path: <";
        int index_begin = plain_text.indexOf(search);
        if (index_begin == -1) {
            return "Unknown";
        }
        index_begin += search.length();
        int index_end = plain_text.indexOf(">", index_begin);
        if (index_end == -1) {
            return "Unknown";
        }
        return plain_text.substring(index_begin, index_end);
    }
    
    private static String getTo(String plain_text) {
        String to = "";
        if (plain_text.contains(GMAIL)) {
            to = getToFromGmail(plain_text);
        } else if (plain_text.contains(HOTMAIL)) {
            to = getToFromHotmail(plain_text);
        } else if (plain_text.contains(YAHOO)) {
            to = getToFromYahoo(plain_text);
        }
        return to;
    }
    
    private static String getSubject(String plain_text) {
        String search = "Subject: ";
        int i = plain_text.indexOf(search);
        if (i == -1) {
            return "No Subject";
        }
        i += search.length();
        String end_string = "";
        if (plain_text.contains(GMAIL)) {
            end_string = "To:";
        } else if (plain_text.contains(HOTMAIL)) {
            end_string = "Thread-Topic";
        } else if (plain_text.contains(YAHOO)) {
            end_string = "MIME-Version:";
        }
        int e = plain_text.indexOf(end_string, i);
        if (e == -1) {
            return "No Subject";
        }
        return plain_text.substring(i, e).trim();
    }
    
    private static String getToFromGmail(String plain_text) {
        return getToCommon(plain_text);
    }
    
    private static String getToFromHotmail(String plain_text) {
        String aux = getToCommon(plain_text);
        return aux.substring(1, aux.length() - 1);
    }
    
    private static String getToFromYahoo(String plain_text) {
        int index = plain_text.indexOf("To: ");
        if (index == -1) {
            return "Unknown";
        }
        int i = plain_text.indexOf("<", index);
        int e = plain_text.indexOf(">", i);
        if (i == -1 || e == -1) {
            return "Unknown";
        }
        return plain_text.substring(i + 1, e);
    }
    
    private static String getToCommon(String plain_text) {
        String aux = "To: ";
        int index_begin = plain_text.indexOf(aux);
        if (index_begin == -1) {
            return "Unknown";
        }
        index_begin += aux.length();
        int index_end = plain_text.indexOf("\n", index_begin);
        if (index_end == -1) {
            return plain_text.substring(index_begin).trim();
        }
        return plain_text.substring(index_begin, index_end).trim();
    }
}
