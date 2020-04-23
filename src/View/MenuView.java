package View;

import Model.Menu;
import Repositories.BookRepository;
import Repositories.MenuRepository;

import java.util.ArrayList;

public class MenuView {
    MenuRepository repository = new MenuRepository();
    BookRepository bookRepository;

    public MenuView(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void ShowAllMenuOptions() {
        ValidateMenuOptions();
        ArrayList<Menu> menuList = repository.getMenuList();
        menuList.forEach(s -> System.out.printf("[%s] - %s\n", s.getOptionId(), s.getOption()));
    }

    private void ValidateMenuOptions(){
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
    }
}
