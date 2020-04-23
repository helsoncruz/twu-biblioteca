package Repositories;

import Model.Menu;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MenuRepository {
    private ArrayList<Menu> menuList;

    public MenuRepository() {
        InitiaLizeMenuList();
    }

    public ArrayList<Menu> getMenuList() {
        return (ArrayList<Menu>) menuList.stream().filter(Menu::isActive).collect(Collectors.toList());
    }

    private void InitiaLizeMenuList(){
        this.menuList = new ArrayList<Menu>();
        this.menuList.add(new Menu(1,"List of available books",true));
        this.menuList.add(new Menu(2,"Check out available book",true));
        this.menuList.add(new Menu(3,"Return a book",true));
        this.menuList.add(new Menu(4,"List of available movies",true));
        this.menuList.add(new Menu(0,"Exit the application ",true));
    }

    public void ActivateMenuOption(int id){
        if(ThisIsvalidId(id))
            menuList.stream().filter(s->s.getOptionId() == id).findFirst().get().setActive(true);
    }
    public void DeactivateMenuOption(int id){
        if(ThisIsvalidId(id))
            menuList.stream().filter(s->s.getOptionId() == id).findFirst().get().setActive(false);
    }
    private boolean ThisIsvalidId(int id){
        if(menuList.stream().noneMatch(s->s.getOptionId() == id)){
            return false;
        }
        return true;
    }
}
