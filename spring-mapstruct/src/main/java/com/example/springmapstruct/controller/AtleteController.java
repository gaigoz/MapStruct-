package com.example.springmapstruct.controller;

import com.example.springmapstruct.dto.AtleteDto;
import com.example.springmapstruct.mapper.AtleteMapper;
import com.example.springmapstruct.model.Atlete;
import com.example.springmapstruct.repository.AtleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtleteController {

    @Autowired
    private AtleteMapper atleteMapper;

    @Autowired
    private AtleteRepository atleteRepository;

    @PostMapping("/atletes")
    public ResponseEntity<Atlete> save(@RequestBody AtleteDto atleteDto){
        return new ResponseEntity<>(atleteRepository.save(
                atleteMapper.dtoToModel(atleteDto)), HttpStatus.CREATED);

    }

    @GetMapping("/atletes")
    public ResponseEntity<List<AtleteDto>> findAll(){
        return new ResponseEntity<>(atleteMapper.modelstoDtos(atleteRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/atletes/{id}")
    public ResponseEntity<AtleteDto> findById(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(atleteMapper.modelToDto(atleteRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/atletes/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id){
        AtleteDto  atleteDto = atleteMapper.modelToDto(atleteRepository.findById(id).get());
        atleteRepository.deleteById(atleteDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atletes/{id}")
    public ResponseEntity<Atlete> update(@PathVariable(value = "id") Integer id){
        /*AtleteDto  atleteDto = atleteMapper.modelToDto(atleteRepository.findById(id).get());

        return new ResponseEntity<>(atleteRepository.save(
                atleteMapper.updateAtleteFromDto(atleteDto)), HttpStatus.CREATED);*/
        return null;
    }
}
