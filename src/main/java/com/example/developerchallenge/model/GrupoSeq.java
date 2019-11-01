
package com.example.developerchallenge.model;

import com.example.developerchallenge.model.base.BaseIdEntity;
import com.example.developerchallenge.util.ValuesUtil;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Grupo_SeqType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "numSeq",
    "indrCont"
})
@Entity(name = "grupo_seq")
public class GrupoSeq extends BaseIdEntity {

    @XmlElement(name = "NumSeq", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String numSeq;
    @XmlElement(name = "IndrCont", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String indrCont;
}
