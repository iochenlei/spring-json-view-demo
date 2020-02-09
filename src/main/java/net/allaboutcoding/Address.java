package net.allaboutcoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

public class Address {
    @JsonView(UserProfile.PublicView.class)
    private String province;

    @JsonView(UserProfile.PublicView.class)
    private String city;

    @JsonView(UserProfile.PrivateView.class)
    private String detailed;

    public Address(String province, String city, String detailed) {
        this.province = province;
        this.city = city;
        this.detailed = detailed;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDetailed() {
        return detailed;
    }
}
