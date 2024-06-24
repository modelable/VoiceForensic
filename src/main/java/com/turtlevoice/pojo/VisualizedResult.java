package com.turtlevoice.pojo;

import com.turtlevoice.voiceforensic.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualizedResult {
    private Integer userId;
    private Result result;
    private RecordCoefAvg recordCoefAvg;
    private ControlCoef controlCoef;
}
