package pe.edu.upao.alozano.web.reservation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upao.alozano.web.customer.domain.Customer;
import pe.edu.upao.alozano.web.restaurant.domain.OpenTable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Customer customer;

    @ManyToOne
    OpenTable openTable;

    LocalDateTime date;

    LocalDateTime createdAt;
}
