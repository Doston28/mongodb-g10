package pdp.uz.mongodbg10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private String title;
    private InputStream stream;

}
