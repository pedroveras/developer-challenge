
package com.example.developerchallenge.model;

import com.example.developerchallenge.model.base.BaseIdEntity;
import com.example.developerchallenge.util.ValuesUtil;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Grupo_SLC0001_LiquidType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "dtLiquid",
    "numSeqCicloLiquid",
    "grupoSLC0001Prodt"
})
@Entity(name = "grupo_slc0001_liquid")
public class GrupoSLC0001Liquid extends BaseIdEntity {

    @XmlElement(name = "DtLiquid", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String dtLiquid;
    @XmlElement(name = "NumSeqCicloLiquid", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String numSeqCicloLiquid;
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Grupo_SLC0001_Prodt", namespace = ValuesUtil.NAMESPACE)
    protected List<GrupoSLC0001Prodt> grupoSLC0001Prodt;
}
