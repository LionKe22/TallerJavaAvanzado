package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animales.AnimalesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    //    private final MyUseCase useCase;
    private AnimalesUseCase animalesUseCase;

    @GetMapping(path = "/animales/{nombre}")
    public Animales read(@PathVariable String nombre) {
        return animalesUseCase.read(nombre);
    }

    @PostMapping(path = "/animales")
    public void create(@RequestBody Animales animales) {
        animalesUseCase.create(animales);
    }

    @PutMapping(path = "/animales/{nombre}")
    public void update(@PathVariable String nombre,@RequestBody Animales animales){
        try {
            animalesUseCase.update(nombre,animales);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
    @DeleteMapping(path="/animales/{nombre}")
    public void delete (@PathVariable String nombre){ animalesUseCase.delete(nombre);}

    @GetMapping(path="/animales")
    public List<Animales> getAll() {return animalesUseCase.getAll();}


}
