package com.example.lababoot.converter;

import com.example.lababoot.dto.CarDTO;
import com.example.lababoot.factory.CarFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarConverter {

    private static final List<CarDTO> carDTOS = new ArrayList<>();

    public static List<CarDTO> getCars(String nameFile) {
        List<CarDTO> cars = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
//            InputStream inputStream = XMLReader.class.getResourceAsStream("/cars.xml");
            Document document = builder.parse(nameFile);
            NodeList list = document.getElementsByTagName("car");
            for (int i = 0; i < list.getLength(); i++) {
                Node nNode = list.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    CarDTO carDTO = CarFactory.createCar(eElement.getElementsByTagName("engine_power").item(0).getTextContent(),
                             eElement.getElementsByTagName("body_type").item(0).getTextContent(),
                            eElement.getElementsByTagName("color").item(0).getTextContent(),
                            eElement.getElementsByTagName("manufacture").item(0).getTextContent(),
                            eElement.getElementsByTagName("model").item(0).getTextContent(),
                            eElement.getElementsByTagName("price").item(0).getTextContent(),
                            eElement.getElementsByTagName("year_of_issue").item(0).getTextContent());

                    cars.add(carDTO);
                }
            }



        } catch (SAXException | IOException | ParserConfigurationException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }



    public static List<CarDTO> getCarsFromSax(String nameFile) throws IOException, SAXException, ParserConfigurationException {
//        List<CarDTO> carDTOS = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(new File(nameFile), handler);

        for (CarDTO car : carDTOS)
            System.out.printf("Производитель: %s, модель: %s%n", car.getManufacture(), car.getModel());
        return carDTOS;
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String manufacture;
        private String model;
        private String body_type;
        private String color;
        private String price;
        private String engine_power;
        private String year_of_issue;
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("manufacture"))
                    manufacture = information;
                if (lastElementName.equals("model"))
                    model = information;
                if (lastElementName.equals("body_type"))
                    body_type = information;
                if (lastElementName.equals("color"))
                    color = information;
                if (lastElementName.equals("price"))
                    price = information;
                if (lastElementName.equals("engine_power"))
                    engine_power = information;
                if (lastElementName.equals("year_of_issue"))
                    year_of_issue = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ( (manufacture != null && !manufacture.isEmpty()) &&
                    (model != null && !model.isEmpty()) &&
                    (body_type != null && !body_type.isEmpty()) &&
                    (price != null && !price.isEmpty()) &&
                    (engine_power != null && !engine_power.isEmpty()) &&
                    (year_of_issue != null && !year_of_issue.isEmpty()) &&
                    (color != null && !color.isEmpty())  ) {
                carDTOS.add(new CarDTO(engine_power, body_type, color, manufacture, model, price, year_of_issue));
                manufacture = null;
                model = null;
                body_type = null;
                price = null;
                engine_power = null;
                year_of_issue = null;
                color = null;
            }
        }
    }
}
