package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ServiceProvider_table")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private Admin admin;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Connection> connectionList;

    @ManyToMany(mappedBy = "serviceProviderList", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Country> countryList;

    public ServiceProvider() {
        connectionList = new ArrayList<>();
        countryList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
