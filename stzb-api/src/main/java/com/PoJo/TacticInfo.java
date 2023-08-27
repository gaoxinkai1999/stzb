package com.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TacticInfo {
    private String name;
    private String type;
}
