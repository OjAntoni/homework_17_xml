package Parser.DOMparser;

import Parser.Parser;
import model.Poem;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMparser implements Parser {
    @Override
    public void startParsing(File file) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("firstName");
            if (nodes.getLength()!=1) throw new IOException("invalid format for data");
            Node node = nodes.item(0);
            Element e = (Element) node;
            Poem.setFirstname(e.getTextContent());

            nodes = document.getElementsByTagName("lastName");
            if (nodes.getLength()!=1) throw new IOException("invalid format for data");
            node = nodes.item(0);
            e = (Element) node;
            Poem.setLastname(e.getTextContent());

            nodes = document.getElementsByTagName("yearOfBirth");
            if (nodes.getLength()!=1) throw new IOException("invalid format for data");
            node = nodes.item(0);
            e = (Element) node;
            Poem.setYearOfBirth(e.getTextContent());

            nodes = document.getElementsByTagName("yearOfDeath");
            if (nodes.getLength()!=1) throw new IOException("invalid format for data");
            node = nodes.item(0);
            e = (Element) node;
            Poem.setYearOfDeath(e.getTextContent());

            nodes = document.getElementsByTagName("title");
            if (nodes.getLength()!=1) throw new IOException("invalid format for data");
            node = nodes.item(0);
            e = (Element) node;
            Poem.setTitle(e.getTextContent());

            nodes = document.getElementsByTagName("line");
            for(int i = 0; i < nodes.getLength(); i++){
                node = nodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    e = (Element) node;
                    Poem.addToPoem(e.getTextContent().replaceAll("\n", "")+"\n");
                }
            }



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
