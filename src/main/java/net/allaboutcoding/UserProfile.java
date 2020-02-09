package net.allaboutcoding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

public class UserProfile {
    public interface PublicView {}
    public interface PrivateView extends PublicView {}

    @JsonView(PublicView.class)
    private String username;

    @JsonView(PrivateView.class)
    private Address address;

    public UserProfile(String username, Address address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }
}
