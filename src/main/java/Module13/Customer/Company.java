package Module13.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

}
