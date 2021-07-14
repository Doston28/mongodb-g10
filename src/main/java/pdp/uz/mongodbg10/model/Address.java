package pdp.uz.mongodbg10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Address {
    @Id
    private String id;

    private String street;

    private String homeNumber;

    private District district;
}
