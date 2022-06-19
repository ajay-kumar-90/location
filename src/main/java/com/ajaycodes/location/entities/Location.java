package com.ajaycodes.location.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Location {
    @Id
    private Long id;
    private String code;
    private String name;
    private String type;

}
