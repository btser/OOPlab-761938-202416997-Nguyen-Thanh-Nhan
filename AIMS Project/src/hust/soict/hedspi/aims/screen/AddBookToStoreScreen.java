package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.JOptionPane;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
        setVisible(true);
    }

    @Override
    protected void btnAddPressed() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book( title, category, cost);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            this.dispose();
            new StoreManagerScreen(store);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Check your input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}