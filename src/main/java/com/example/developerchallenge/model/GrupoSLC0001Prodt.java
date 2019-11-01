
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
@XmlType(name = "Grupo_SLC0001_ProdtType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "codProdt",
    "grupoSLC0001LiquidProdt"
})
@Entity(name = "grupo_slc0001_produt")
public class GrupoSLC0001Prodt extends BaseIdEntity {

    @XmlElement(name = "CodProdt", namespace = ValuesUtil.NAMESPACE, required = true)
    protected String codProdt;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Grupo_SLC0001_LiquidProdt", namespace = ValuesUtil.NAMESPACE)
    protected List<GrupoSLC0001LiquidProdt> grupoSLC0001LiquidProdt;
}
