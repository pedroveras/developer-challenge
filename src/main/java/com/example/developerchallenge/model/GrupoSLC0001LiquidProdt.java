
package com.example.developerchallenge.model;

import com.example.developerchallenge.model.base.BaseIdEntity;
import com.example.developerchallenge.util.ValuesUtil;
import javax.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Grupo_SLC0001_LiquidProdtType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "identdLinhaBilat",
    "tpDebCred",
    "ispbifCredtd",
    "ispbifDebtd",
    "vlrLanc",
    "cnpjnLiqdantDebtd",
    "nomCliDebtd",
    "cnpjnLiqdantCredtd",
    "nomCliCredtd",
    "tpTranscSLC"
})
@Entity(name = "grupo_slc0001_liquid_prodt")
public class GrupoSLC0001LiquidProdt extends BaseIdEntity {

    @XmlElement(name = "IdentdLinhaBilat", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String identdLinhaBilat;
    @XmlElement(name = "TpDeb_Cred", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String tpDebCred;
    @XmlElement(name = "ISPBIFCredtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String ispbifCredtd;
    @XmlElement(name = "ISPBIFDebtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String ispbifDebtd;
    @XmlElement(name = "VlrLanc", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String vlrLanc;
    @XmlElement(name = "CNPJNLiqdantDebtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String cnpjnLiqdantDebtd;
    @XmlElement(name = "NomCliDebtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String nomCliDebtd;
    @XmlElement(name = "CNPJNLiqdantCredtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String cnpjnLiqdantCredtd;
    @XmlElement(name = "NomCliCredtd", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String nomCliCredtd;
    @XmlElement(name = "TpTranscSLC", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String tpTranscSLC;
}
