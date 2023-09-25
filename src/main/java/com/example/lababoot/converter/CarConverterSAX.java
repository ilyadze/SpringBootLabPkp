package com.example.lababoot.converter;

import com.example.lababoot.dto.CarDTO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarConverterSAX {

    private static final List<CarDTO> carDTOS = new ArrayList<>();

    public static List<CarDTO> getCarsFromSax(String nameFile) throws IOException, SAXException, ParserConfigurationException {
//        List<CarDTO> carDTOS = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        CarConverterSAX.AdvancedXMLHandler handler = new CarConverterSAX.AdvancedXMLHandler();
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
