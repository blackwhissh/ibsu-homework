package com.ibsu.homework.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(sequenceName = "address_id_seq", name = "address_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "address_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", nullable = false)
    private Integer addressId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "address")
    private String address;

    public Address(Integer addressId, City city, String address) {
        this.addressId = addressId;
        this.city = city;
        this.address = address;
    }
    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
