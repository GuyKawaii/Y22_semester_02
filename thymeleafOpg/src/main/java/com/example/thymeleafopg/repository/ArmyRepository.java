package com.example.thymeleafopg.repository;

import java.util.ArrayList;
import java.util.List;

public class ArmyRepository {
    private List<String> soldiers = new ArrayList<>();

    public ArmyRepository() {
        soldiers.add("Peter");
        soldiers.add("Pan");
        soldiers.add("er");
        soldiers.add("en");
        soldiers.add("%&¤&[");
        soldiers.add("and that's a good thing");
    }

    public List<String> getSoldiers() {
        return soldiers;
    }

}
