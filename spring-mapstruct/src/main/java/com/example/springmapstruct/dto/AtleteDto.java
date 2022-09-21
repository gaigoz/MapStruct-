package com.example.springmapstruct.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class AtleteDto {

    @Id
    private int id;
    private String nome;
    private String data;
    private String description;
    private String itemId;
    private String quantidade;


}
