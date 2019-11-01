
package com.example.developerchallenge.model;

import com.example.developerchallenge.model.base.BaseIdEntity;
import com.example.developerchallenge.util.ValuesUtil;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOCType", namespace = ValuesUtil.NAMESPACE, propOrder = {
    "bcmsg",
    "sismsg"
})
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"bcmsg_id", "sismsg_id"})
})
public class Doc extends BaseIdEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "BCMSG", namespace = ValuesUtil.NAMESPACE, required = true)
    protected BCMSG bcmsg;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "SISMSG", namespace = ValuesUtil.NAMESPACE, required = true)
    protected SISMSG sismsg;
}
