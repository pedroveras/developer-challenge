package com.example.developerchallenge.service;

import com.example.developerchallenge.model.Doc;
import com.example.developerchallenge.repository.SLCRepository;
import com.example.developerchallenge.util.ValuesUtil;
import java.io.StringWriter;
import java.util.Optional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLCServiceImpl implements SLCService {

    @Autowired
    private SLCRepository repository;


    private static JAXBContext context;

    static{
        try {
            context = JAXBContext.newInstance("com.example.developerchallenge.model");
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void salvarArquivo(Doc doc) {
        repository.save(doc);
    }

    public String carregarArquivo(String nuOp) {
        Optional<Doc> doc = repository.getByNuOp(nuOp);

        if (doc.isPresent())
            return marshal(doc.get());

        return "";
    }

    /**
     * Converte o objeto doc para um xml
     * @param doc
     * @return String representando arquivo xml
     */
    private String marshal(Doc doc) {
        Marshaller jaxbMarshaller;
        StringWriter slc0001 = new StringWriter();

        try {
            jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            JAXBElement<Doc> jaxbElement =
                    new JAXBElement<>( new QName(ValuesUtil.NAMESPACE, ValuesUtil.ROOT_ELEMENT), Doc.class, doc);

            slc0001.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+System.lineSeparator());
            jaxbMarshaller.marshal(jaxbElement, slc0001);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return slc0001.toString();
    }
}
