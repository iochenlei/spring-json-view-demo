package net.allaboutcoding;

public class UserProfileWithoutDetailedAddressDTO {
    private String username;
    private AddressDTO address;

    public static class AddressDTO {
        private String province;
        private String city;

        public AddressDTO(String province, String city) {
            this.province = province;
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }
    }

    private UserProfileWithoutDetailedAddressDTO(String username, AddressDTO address) {
        this.username = username;
        this.address = address;
    }

    public static UserProfileWithoutDetailedAddressDTO from(UserProfile userProfile) {
        Address address = userProfile.getAddress();
        return new UserProfileWithoutDetailedAddressDTO(userProfile.getUsername(),
                new AddressDTO(address.getProvince(), address.getCity()));
    }

    public String getUsername() {
        return username;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
