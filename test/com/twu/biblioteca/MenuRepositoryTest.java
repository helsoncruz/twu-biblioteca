package com.twu.biblioteca;
import Model.Menu;
import Repositories.MenuRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuRepositoryTest {

    @Test
    public void RepositoryIsNotEmpty() {
        MenuRepository repository = new MenuRepository();
        ArrayList<Menu> menuList = repository.getMenuList();
        assertFalse(menuList.isEmpty());
    }
}
