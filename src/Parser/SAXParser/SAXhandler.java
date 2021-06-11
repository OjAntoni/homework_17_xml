package Parser.SAXParser;

import model.Poem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXhandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();
    String lastName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        lastName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch,start,length);
        if(!data.isEmpty() && !data.startsWith("\n")){
            switch (lastName){
                case "lastName" -> Poem.setLastname(data);
                case "firstName" -> Poem.setFirstname(data);
                case "nationality" -> Poem.setNationality(data);
                case "yearOfBirth" -> Poem.setYearOfBirth(data);
                case "yearOfDeath" -> Poem.setYearOfDeath(data);
                case "title" -> Poem.setTitle(data);
                case "line" -> Poem.addToPoem(data.replaceAll("\n", "")+"\n");
            }
        }
    }

}
