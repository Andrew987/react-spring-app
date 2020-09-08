package cz.mailmuni.andris.reactspringapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    private String addressLine;

    private String city;

    private String country;

    private String stateOrProvince;

    private String postalCode;

    public Address() {
    }

    public Address(String addressLine, String city, String country, String stateOrProvince, String postalCode) {
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stateOrProvince='" + stateOrProvince + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
