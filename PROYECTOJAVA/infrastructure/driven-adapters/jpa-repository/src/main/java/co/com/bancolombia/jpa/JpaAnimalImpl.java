package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class JpaAnimalImpl  implements AnimalesRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animales animales){
        //  String nombre = UUID.randomUUID().toString();
        //  animales.setNombre(nombre);
        jpaRepositoryAdapter.save(animales);

    }

    @Override
    public Animales read(String nombre){
        return jpaRepositoryAdapter.findById(nombre);

    }
    @Override
    public void update(String nombre, Animales animales) throws Exception {

        Animales animales0b = jpaRepositoryAdapter.findById(nombre);
        if (animales0b==null) throw new Exception("Animal Not Found: " + nombre);
        animales0b.setNombre(animales.getNombre());
        animales0b.setEspecie(animales.getEspecie());
        animales0b.setGenero(animales.getGenero());
        animales0b.setNumeropatas(animales0b.getNumeropatas());
        animales0b.setHabitad(animales.getHabitad());
        animales0b.setDomestico(animales.getDomestico());
        jpaRepositoryAdapter.save(animales0b);


    }
    @Override
    public void delete(String nombre){
        jpaRepositoryAdapter.deleteById(nombre);
    }

    @Override
    public List<Animales> getAll() {return jpaRepositoryAdapter.findAll();}


}
