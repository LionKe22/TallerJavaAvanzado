package co.com.bancolombia.jpa.entities;

import lombok.*;

import javax.persistence.*;

   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   @Builder
   @Entity
   @Table(name="animales")
public class AnimalEntity {
    @Id
    private String nombre;
    @Column private String especie;
    @Column private Integer numeropatas;
    @Column private Character genero;
    @Column private String habitad;
    @Column private Boolean domestico;
}
