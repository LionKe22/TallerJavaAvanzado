package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animales;

import java.util.List;

public interface AnimalesRepository {
    void create (Animales animales);
    Animales read (String Nombre);
    default void update (String Nombre, Animales animales) throws Exception{

    }
    void delete (String Nombre);
    List<Animales> getAll();

}
