package com.example.developerchallenge.model.base;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseEntity {

    @CreationTimestamp
    @XmlTransient
    protected LocalDateTime atualizadoEm;

    @UpdateTimestamp
    @XmlTransient
    protected LocalDateTime criadoEm;
}
