package ru.schepin.hiberntate.model;

import lombok.*;

import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode(exclude = "users")

public class Car {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String marka;

    @Getter
    @Setter
    private String model;

    @Getter
    @Setter
    private Set<User> users;


}
