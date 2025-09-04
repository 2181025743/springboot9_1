package yx.model;

import lombok.Data;

@Data
public class Score {
    private Integer chinese;
    private Integer math;
    private Integer english;

    public Double getAverage() {
        return (chinese + math + english) / 3.0;
    }
}