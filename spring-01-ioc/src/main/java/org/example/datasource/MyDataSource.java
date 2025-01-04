package org.example.datasource;


import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class MyDataSource {

    private String url;
    private String username;
    private String password;

}
