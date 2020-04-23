package com.twu.biblioteca;
import Model.Menu;
import Repositories.MenuRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuRepositoryTest {
    MenuRepository repository = new MenuRepository();
    @Test
    public void ValidateIfRepositoryIsNotEmpty() {
        ArrayList<Menu> menuList = repository.getMenuList();
        assertFalse(menuList.isEmpty());
    }

    @Test
    public void ShouldDeactivateTheMenuOption() {
        repository.DeactivateMenuOption(1);
        ArrayList<Menu> menuList = repository.getMenuList();
        assertTrue(menuList.stream().noneMatch(s->s.getOptionId() == 1));
    }

    @Test
    public void ShouldActivateTheMenuOption() {
        repository.DeactivateMenuOption(1);
        repository.ActivateMenuOption(1);
        ArrayList<Menu> menuList = repository.getMenuList();
        assertTrue(menuList.stream().anyMatch(s->s.getOptionId() == 1));
    }
}
