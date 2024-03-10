package Module13.Customer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public record CustomerResponseDto(
        Long id,
        String name,
        List<Address> address,
        String phone,
        String website,
        List<Company> company) {

    public CustomerResponseDto(Long id, String name, List<Address> address, String phone, String website, List<Company> company) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
}
