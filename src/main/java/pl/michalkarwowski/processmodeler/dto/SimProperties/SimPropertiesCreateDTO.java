package pl.michalkarwowski.processmodeler.dto.SimProperties;

import lombok.Data;

@Data
public class SimPropertiesCreateDTO {
    private String name;
    private String time;
    private String unit;
    private String rate;
}
