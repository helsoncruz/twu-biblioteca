package Model;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Book> order = new ArrayList<Book>();

    public ArrayList<Book> getOrder() {
        return order;
    }

    public void addOrderBook(Book book) {
        this.order.add(book);
    }
}
