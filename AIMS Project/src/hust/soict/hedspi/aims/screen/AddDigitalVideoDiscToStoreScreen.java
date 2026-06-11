package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
        
        addInputRow(centerPanel, "Director:", tfDirector = new JTextField());
        addInputRow(centerPanel, "Length:", tfLength = new JTextField());
        
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

            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            this.dispose();
            new StoreManagerScreen(store);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Check your input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}