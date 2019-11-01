
package com.example.developerchallenge.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final String NAMESPACE = "http://www.bcb.gov.br/SPB/SLC0001.xsd";
    private static final String ROOT = "DOC";

    private final static QName _DOC_QNAME = new QName(NAMESPACE, ROOT);

    public ObjectFactory() {
    }

    public GrupoSLC0001Liquid createGrupoSLC0001LiquidType() {
        return new GrupoSLC0001Liquid();
    }

    public SLC0001 createSLC0001Type() {
        return new SLC0001();
    }

    public GrupoSLC0001Prodt createGrupoSLC0001ProdtType() {
        return new GrupoSLC0001Prodt();
    }

    public GrupoSeq createGrupoSeqType() {
        return new GrupoSeq();
    }

    public Doc createDOCType() {
        return new Doc();
    }

    public SISMSG createSISMSGType() {
        return new SISMSG();
    }

    public BCMSG createBCMSGType() {
        return new BCMSG();
    }

    public GrupoSLC0001LiquidProdt createGrupoSLC0001LiquidProdtType() {
        return new GrupoSLC0001LiquidProdt();
    }

    public SLC0001 createSLC0001() {
        return new SLC0001();
    }

    @XmlElementDecl(namespace = NAMESPACE, name = ROOT)
    public JAXBElement<Doc> createDOC(Doc value) {
        return new JAXBElement<Doc>(_DOC_QNAME, Doc.class, null, value);
    }
}
