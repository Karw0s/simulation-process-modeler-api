package pl.michalkarwowski.processmodeler.dto.SimProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimulationPropertiesDTO {
    private Long id;
    private String name;
    private String time;
    private String unit;
    private String rate;
}
