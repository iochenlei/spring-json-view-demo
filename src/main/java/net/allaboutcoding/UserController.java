package net.allaboutcoding;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    private final UserProfile userProfile = new UserProfile("sword4j", new Address("湖北", "武汉市", "光谷大道xx小区xx号"));

    @GetMapping("/profile")
    public UserProfile getProfile() {
        return userProfile;
    }

    @GetMapping("/profile-using-dto")
    public UserProfileWithoutDetailedAddressDTO getProfileUsingDTO() {
        return UserProfileWithoutDetailedAddressDTO.from(userProfile);
    }

    @GetMapping("/profile-using-null")
    public UserProfile getProfileUsingNull() {
        // 把detailed字段设为null
        Address address = new Address(userProfile.getAddress().getProvince(),
                userProfile.getAddress().getCity(), null);
        return new UserProfile(userProfile.getUsername(), address);
    }

    @GetMapping("/profile-public-view")
    @JsonView(UserProfile.PublicView.class)
    public UserProfile getPublicInfo() {
        return userProfile;
    }

    @GetMapping("/profile-private-view")
    @JsonView(UserProfile.PrivateView.class)
    public UserProfile getPrivateInfo() {
        return userProfile;
    }

    @GetMapping("/profiles/public-view")
    @JsonView(UserProfile.PublicView.class)
    public List<UserProfile> getPublicInfoOnList() {
        return Collections.singletonList(userProfile);
    }

    @GetMapping("/profiles/private-view")
    @JsonView(UserProfile.PrivateView.class)
    public List<UserProfile> getPrivateInfoOnList() {
        return Collections.singletonList(userProfile);
    }
}
