package View;

import Model.Menu;
import Repositories.MenuRepository;

import java.util.ArrayList;

public class MenuView {
    MenuRepository repository = new MenuRepository();

    public void ShowAllMenuOptions(){
        ArrayList<Menu> menuList = repository.getMenuList();
        menuList.forEach(s-> System.out.printf("[%s] - %s\n", s.getOptionId(), s.getOption()));
    }
}
