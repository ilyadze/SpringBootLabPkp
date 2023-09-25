package com.example.lababoot.facade;

import com.example.lababoot.converter.CarConverterDOM;
import com.example.lababoot.converter.CarConverterSAX;
import com.example.lababoot.dto.CarDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ConverterFacade {


    public static List<CarDTO> getCarsFromSax(String nameFile) throws IOException, SAXException, ParserConfigurationException {

        return CarConverterSAX.getCarsFromSax(nameFile);
    }

    public static List<CarDTO> getCars(String nameFile) {
        return CarConverterDOM.getCars(nameFile);
    }
}
