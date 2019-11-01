
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
import lombok.Data;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SISMSGType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "slc0001"
})
@Entity(name = "sismsg")
public class SISMSG extends BaseIdEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "SLC0001", namespace = ValuesUtil.NAMESPACE, required = true)
    protected SLC0001 slc0001;
}
