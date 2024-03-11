package Module13.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private List<Geo> geo;


}

