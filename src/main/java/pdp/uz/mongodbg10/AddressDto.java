package pdp.uz.mongodbg10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String street;

    private String homeNumber;

    private String districtId;

}
