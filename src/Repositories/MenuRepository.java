package Repositories;

import Model.Menu;

import java.util.ArrayList;

public class MenuRepository {
    private ArrayList<Menu> menuList = new ArrayList<Menu>();

    public MenuRepository() {
        InitiaLizeMenuList();
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    private void InitiaLizeMenuList(){
        this.menuList.add(new Menu(1,"List of available books",true));
        this.menuList.add(new Menu(2,"Check out available book",true));
        this.menuList.add(new Menu(0,"Exit the application ",true));
    }
}
