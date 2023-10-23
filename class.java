class AddProductListener implements ActionListener {
    private JTextField nameField;
    private JTextField colorField;
    private JTextField priceField;
    private JTextArea displayArea;
    private Store store;

    public AddProductListener(JTextField nameField, JTextField colorField, JTextField priceField, JTextArea displayArea, Store store) 
    {
        this.nameField = nameField;
        this.colorField = colorField;
        this.priceField = priceField;
        this.displayArea = displayArea;
        this.store = store;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String name = nameField.getText();
        String color = colorField.getText();

        double price;
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for price. Please enter a valid number.");
            return;
        }

        Product product = new Product(name, color, price);
        store.addProduct(product);

        updateDisplay(displayArea, store);
    }
}