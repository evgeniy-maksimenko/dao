package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {
    ArrayList<PersonModel> arrayListPerson = new ArrayList<PersonModel>();

    public ArrayList parse() {
        parseCSV(readFromFile("person.xml"));
        return arrayListPerson;
    }
    
    private String parseCSV(String content) {
        if (content.startsWith("<?")) {
            String[] contentWithoutTagXML = content.split("\\?>");
            return parseCSV(contentWithoutTagXML[1]);
        } else if (content.startsWith("<Persons>") && content.endsWith("</Persons>")) {
            String[] contentSplitStart = content.split("<Persons>");
            String[] contentSplitEnd   = contentSplitStart[1].split("</Persons>");
            
            String contentReplaceStart = contentSplitEnd[0].replaceAll("<Person>", "");
            String contentReplaceEnd   = contentReplaceStart.replaceAll("</Person>", ";");
            return parseCSV(contentReplaceEnd);
        } else {
            int pos = 0;
            while (pos < content.length()) {
                if (content.charAt(pos) == ';') {
                    String contentTags = content.substring(0, pos);
                    parseCSVContent(contentTags);
                    return parseCSV(content.substring(pos + 1));
                } else {
                    pos++;
                }
            }
            return "";
        }
    }

    private void parseCSVContent(String content) {
        arrayListPerson.add(
                new PersonModel(
                        Integer.parseInt(getValue("id", content)), 
                        getValue("first_name", content), 
                        getValue("last_name", content)));
    }
    
    private String getValue(String key, String content) {
        String[] contentStart = content.split("<"+key+">");
        String[] contentEnd   = contentStart[1].split("</"+key+">");
        return contentEnd[0];
    }

    public String readFromFile(String Name) {
        String result = "";
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(Name));
            String currentLine;
            while ((currentLine = buffer.readLine()) != null) {
                result += currentLine.replaceAll("\\s", "");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
