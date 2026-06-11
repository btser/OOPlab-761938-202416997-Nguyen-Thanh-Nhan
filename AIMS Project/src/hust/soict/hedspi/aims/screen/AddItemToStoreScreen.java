package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JTextField tfId;
    protected Store store;
    protected JPanel centerPanel;
    protected JTextField tfTitle, tfCategory, tfCost, tfDirector, tfLength, tfArtist;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        
        centerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        addInputRow(centerPanel, "Id:", tfId = new JTextField());
        addInputRow(centerPanel, "Title:", tfTitle = new JTextField());
        addInputRow(centerPanel, "Category:", tfCategory = new JTextField());
        addInputRow(centerPanel, "Cost:", tfCost = new JTextField());
        addInputRow(centerPanel, "Director:", tfDirector = new JTextField());
        addInputRow(centerPanel, "Length:", tfLength = new JTextField());
        addInputRow(centerPanel, "Artist:", tfArtist = new JTextField());

        cp.add(centerPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> btnAddPressed());
        cp.add(btnAdd, BorderLayout.SOUTH);

        setTitle(title);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void addInputRow(JPanel panel, String labelText, JTextField textField) {
        panel.add(new JLabel(labelText));
        panel.add(textField);
    }

    protected abstract void btnAddPressed();

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store);
            this.dispose();
        });
        menu.add(viewStore);
        menuBar.add(menu);
        return menuBar;
    }
}