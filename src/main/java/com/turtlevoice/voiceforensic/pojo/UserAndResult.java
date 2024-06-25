package com.turtlevoice.voiceforensic.pojo;

import com.turtlevoice.voiceforensic.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndResult {
    private Integer userId;
    private Result result;
}
