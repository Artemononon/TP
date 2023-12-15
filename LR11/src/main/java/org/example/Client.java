package org.example;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long client_id;

    @Column(name = "client_name", nullable = false)
    private String client_name;

    @Column(name = "client_fam", nullable = false)
    private String client_fam;

    @OneToMany(mappedBy = "client")
    private List<Orders> orders;

    public Client() {
    }

    public Client(String client_name, String client_fam) {
        this.client_name = client_name;
        this.client_fam = client_fam;
        this.orders = new ArrayList<>();;
    }

    @Override
    public String toString() {
        return "Клиент(" + client_id + ", " + client_name + ", " + client_fam + ")";
    }

    public Long getClientId() {
        return client_id;
    }

    public String getClientName() {
        return client_name;
    }

    public String getClientFam() {
        return client_fam;
    }

    public List<Orders> getOrders() {
        return orders;
    }


    public void setClientId(Long client_id) {
        this.client_id = client_id;
    }

    public void setClientName(String client_name) {
        this.client_name = client_name;
    }

    public void setClientFam(String client_fam) {
        this.client_fam = client_fam;
    }
}
