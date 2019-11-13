package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        PokemonType res = new PokemonType();
        for (PokemonType p : this.pokemons){
            if (p.getId() == id){
                res = p;
            }
        }
        return res;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        PokemonType res = new PokemonType();
        for (PokemonType p : this.pokemons){
            if (p.getName().equals(name)){
                res = p;
            }
        }
        return res;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return this.pokemons;
    }

    @Override
    public List<PokemonType> findPokemonByTypes(String types) {
        List<PokemonType> l = new ArrayList<PokemonType>();
        for (PokemonType p : this.pokemons){

            if (p.getTypes().containsAll(Arrays.asList(types.split(",")))){
                l.add(p);
            }
        }
        return l;
    }


}
