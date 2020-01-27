package com.example.project.domain.dto.response;

// import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {

    private Integer id;

    private String name;

    private String phone;
    // private Date data;

}