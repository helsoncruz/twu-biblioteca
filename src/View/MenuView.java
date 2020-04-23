package View;

import Model.Menu;
import Repositories.BookRepository;
import Repositories.MenuRepository;

import java.util.ArrayList;

public class MenuView {
    MenuRepository repository = new MenuRepository();


    public MenuView() {

    }

    public void ShowAllMenuOptions(BookRepository bookRepository, boolean authenticated) {
        ValidateMenuOptions(bookRepository, authenticated);
        ArrayList<Menu> menuList = repository.getMenuList();
        menuList.forEach(s -> System.out.printf("\n[%s] - %s", s.getOptionId(), s.getOption()));
    }

    private void ValidateMenuOptions(BookRepository bookRepository, boolean authenticated){
        boolean anyBookAvailable = !bookRepository.getAvailableBookList().isEmpty();
        boolean anyBookUnavailable = !bookRepository.getUnavailableBookList().isEmpty();

        if(!anyBookAvailable){
            repository.DeactivateMenuOption(1);
            repository.DeactivateMenuOption(2);
        }else{
            repository.ActivateMenuOption(1);
            repository.ActivateMenuOption(2);
        }

        if(!anyBookUnavailable){
            repository.DeactivateMenuOption(3);
        }else{
            repository.ActivateMenuOption(3);
        }

        if(!authenticated){
            repository.DeactivateMenuOption(2);
            repository.DeactivateMenuOption(3);
            repository.DeactivateMenuOption(5);
            repository.DeactivateMenuOption(7);
            repository.ActivateMenuOption(6);
        }else{
            repository.ActivateMenuOption(2);
            repository.ActivateMenuOption(3);
            repository.ActivateMenuOption(5);
            repository.ActivateMenuOption(7);
            repository.DeactivateMenuOption(6);
        }
    }
}
