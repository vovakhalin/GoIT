package Module13.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor

public class Geo {
    private Integer lat;
    private Integer lng;

}
