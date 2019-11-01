
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
@XmlType(name = "SLC0001Type", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "codMsg",
    "numCtrlSLC",
    "ispbif",
    "tpInf",
    "grupoSLC0001Liquid",
    "dtHrSLC",
    "dtMovto"
})
@Entity
public class SLC0001 extends BaseIdEntity {

    @XmlElement(name = "CodMsg", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String codMsg;
    @XmlElement(name = "NumCtrlSLC", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String numCtrlSLC;
    @XmlElement(name = "ISPBIF", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String ispbif;
    @XmlElement(name = "TpInf", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String tpInf;
    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "Grupo_SLC0001_Liquid", namespace = ValuesUtil.NAMESPACE, required = true)
    protected GrupoSLC0001Liquid grupoSLC0001Liquid;
    @XmlElement(name = "DtHrSLC", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String dtHrSLC;
    @XmlElement(name = "DtMovto", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String dtMovto;
}
