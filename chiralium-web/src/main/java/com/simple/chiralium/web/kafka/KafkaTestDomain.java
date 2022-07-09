package com.simple.chiralium.web.kafka;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class KafkaTestDomain {
    private String name;

    private String code;

    private String message;
}
