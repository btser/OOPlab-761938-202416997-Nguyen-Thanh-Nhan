package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.JOptionPane;

public class AddDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDiscToStoreScreen(Store store) {
        super(store, "Add Disc to Store");
        setVisible(true);
    }

    @Override
    protected void btnAddPressed() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(title, category, director, length, cost, artist);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "Compact Disc added successfully!");
            this.dispose();
            new StoreManagerScreen(store);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Check your input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}