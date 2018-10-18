package ru.schepin.hiberntate.model;

import lombok.*;

import java.util.Set;

/**
 * Author : Pavel Ravvich.
 * Created : 26/11/2017.
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    private int id;

    private String name;

    private int power;

    private String carMark;

    private Set<Car> cars;
}
