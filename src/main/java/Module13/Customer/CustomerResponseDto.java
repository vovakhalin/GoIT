package Module13.Customer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


public record CustomerResponseDto(
        Long id,
        String name,
        String username,
        List<Address> address,
        String phone,
        String website,
        List<Company> company) {


        public CustomerResponseDto(Long id, String name, String username, List<Address> address, String phone, String website, List<Company> company) {
                this.id = id;
                this.name = name;
                this.username = username;
                this.address = address;
                this.phone = phone;
                this.website = website;
                this.company = company;
        }


}
