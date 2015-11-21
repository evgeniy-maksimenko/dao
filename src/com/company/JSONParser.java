package com.company;

import java.util.ArrayList;

public class JSONParser {
    ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();

    public ArrayList parse() {
        parseJson(new Utils().readFromFile("person.json"));
        return arrayListPerson;
    }

    public String substring(String content) {
        if (content.startsWith("\"") && content.endsWith("\"")) {
            return content.substring(1, content.length() - 1);
        } else {
            return content;
        }
    }

    public String getJsonKeyValue(String key, String currentLine) {
        final String DELIMETER = ":";

        String[] arrayDef = currentLine.split(DELIMETER);

        return substring(arrayDef[0]).equals(key) ? substring(arrayDef[1]) : "";

    }

    public String[] getJsonValue(String currentLine) {
        final String DELIMETER = ":";

        String[] arrayDef = currentLine.split(DELIMETER);

        return new String[]{substring(arrayDef[0]), substring(arrayDef[1])};

    }

    public String parseJsonAList(String content) {

        String id = "";
        String first_name = "";
        String last_name = "";

        if (content.startsWith("{") && content.endsWith("}")) {
            return parseJsonAList(content.substring(1, content.length() - 1));
        } else {

            String[] str = content.split(",");
            for (String aStr : str) {
                if (id.isEmpty()) id = getJsonKeyValue("id", aStr);
                if (first_name.isEmpty()) first_name = getJsonKeyValue("first_name", aStr);
                if (last_name.isEmpty()) last_name = getJsonKeyValue("last_name", aStr);
            }

            arrayListPerson.add(new PersonModel(Integer.parseInt(id), first_name, last_name));

            return content;
        }
    }

    public String parseJson(String content) {
        if (content.startsWith("[") && content.endsWith("]")) {
            return parseJson(content.substring(1, content.length() - 1));
        } else {
            int pos = 0;
            while (pos < content.length()) {
                if (content.charAt(pos) == '}') {
                    String obj;
                    if (content.charAt(0) == ',') {
                        obj = content.substring(1, pos + 1);
                    } else {
                        obj = content.substring(0, pos + 1);
                    }
                    parseJsonAList(obj.replaceAll(" ", ""));
                    return parseJson(content.substring(pos + 1));
                } else {
                    pos++;
                }
            }
            return content;
        }
    }
}
