package pl.michalkarwowski.processmodeler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DiagramDetailsDTO {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String imageUrl;
}
