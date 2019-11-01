
package com.example.developerchallenge.model;

import com.example.developerchallenge.model.base.BaseIdEntity;
import com.example.developerchallenge.util.ValuesUtil;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BCMSGType", namespace = "http://www.bcb.gov.br/SPB/SLC0001.xsd", propOrder = {
    "identdEmissor",
    "identdDestinatario",
    "grupoSeq",
    "domSist",
    "nuOp"
})
@Entity(name = "bcmsg")
public class BCMSG extends BaseIdEntity {

    @XmlElement(name = "IdentdEmissor", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String identdEmissor;
    @XmlElement(name = "IdentdDestinatario", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String identdDestinatario;
    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "Grupo_Seq", namespace = ValuesUtil.NAMESPACE, required = true)
    protected GrupoSeq grupoSeq;
    @XmlElement(name = "DomSist", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String domSist;
    @XmlElement(name = "NUOp", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String nuOp;
}
