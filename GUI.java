import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends ActionListener {
    private Store store;

    public GUI() {
        store = new Store();

        setTitle("Online Store");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //metodă care asigură că at când util închide fereastra principală, întreaga aplicație Swing se va opri.
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }
//tratatrea evenimentelor generate de apasarea butonului AddProduct 
    private void placeComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();
        JButton addButton = new JButton("Add Product");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(colorLabel);
        inputPanel.add(colorField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        JTextArea displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton sortByNameButton = new JButton("Sort by Name");
        JButton sortByPriceButton = new JButton("Sort by Price");
        JButton removeButton = new JButton("Remove Selected");

        buttonPanel.add(sortByNameButton);
        buttonPanel.add(sortByPriceButton);
        buttonPanel.add(removeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        //actionListener este asociat unui buton si executa operatia atunci cand este apasat
        @Override
        addButton.addActionListener(new AddProductListener(nameField, colorField, priceField, displayArea, store));
        sortByNameButton.addActionListener(e -> {
            store.sortProductsByName();
            updateDisplay(displayArea, store);
        });
        sortByPriceButton.addActionListener(e -> {
            store.sortProductsByPrice();
            updateDisplay(displayArea, store);
        });
        removeButton.addActionListener(e -> {
            int selectedIndex = displayArea.getSelectedRow();
            if (selectedIndex != -1) {
                Product selectedProduct = store.getProducts().get(selectedIndex);
                store.removeProduct(selectedProduct);
                updateDisplay(displayArea, store);
            }
        });
    }

    private void updateDisplay(JTextArea displayArea, Store store) {
        //folosim StringBuffer pentru a construi șirul rezultat
        StringBuffer displayBuffer = new StringBuffer();
        for (Product p : store.getProducts()) {
            displayBuffer.append(p.toString()).append("\n");
        }
        displayArea.setText(displayBuffer.toString());
    }
}