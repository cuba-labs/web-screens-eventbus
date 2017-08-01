package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "DEMO_ORDER")
@Entity(name = "demo$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -6595066831649277197L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    @Lob
    @Column(name = "SUMMARY", nullable = false)
    protected String summary;

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }


}