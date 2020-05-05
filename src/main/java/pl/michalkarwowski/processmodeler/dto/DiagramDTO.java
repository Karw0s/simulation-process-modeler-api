package pl.michalkarwowski.processmodeler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DiagramDTO {
    private Long id;
    private String name;
    private String DiagramXML;
}
