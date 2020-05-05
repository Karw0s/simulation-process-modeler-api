package pl.michalkarwowski.processmodeler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Data
public class DiagramCreateDTO {
    private String name;
    private String xml;
    private MultipartFile image;
}
