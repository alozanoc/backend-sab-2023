package pe.edu.upao.alozano.web.restaurant.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    String name;

    @OneToMany(mappedBy = "restaurant")
    List<OpenTable> openTableList;
}
