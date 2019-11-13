package com.ifi.tp.pokemon_type_api.controller;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    PokemonTypeService service;

    public PokemonTypeController(PokemonTypeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable  int id){
        return service.getPokemonType(id);
    }

    @RequestMapping(value ="/" , params ="name")
    PokemonType getPokemonTypeFromName(@RequestParam String name){
        return service.getPokemonType(name);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return service.getAllPokemonTypes();
    }

    @RequestMapping(value ="/" , params ="types")
    List<PokemonType> getPokemonTypeFromType(@RequestParam String types){
        return service.getPokemonByTypes(types);
    }


}
