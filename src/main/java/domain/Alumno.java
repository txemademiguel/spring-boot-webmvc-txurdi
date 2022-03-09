package domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity
//@Entity(name = "Alumnos")
//@Table(name = ""ALUMNOS)
public class Alumno {

    @Id
    @GeneratedValue
    //@Column(name = "ID")
    private Long id;

    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    private String nombre;

    private String apellidos;

    @Min(value = 18, message = "el usuario debe tener 18+")
    private  Integer edad;

}
