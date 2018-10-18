package ru.schepin.hiberntate.model;


import lombok.*;

import java.util.Date;
import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode(exclude = "cars")
public class User {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private Set<Car> cars;


}
