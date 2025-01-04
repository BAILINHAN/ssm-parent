package org.example.bean;


import lombok.Data;
import lombok.Getter;
import org.example.annotation.UUID;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car {

    @UUID
    private String id;
}
