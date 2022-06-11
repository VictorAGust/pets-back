package br.com.adopt.petsback.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Adoption {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private String email;

    @ManyToOne()
    private Pet pet;
}
