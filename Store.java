//clasa Store gestioneaza o lista dinamica de obiecte de tip Product

class Store {
    private ArrayList<Product> products;

    public Store() {
        //constructorul initializeaza lista de produse
        products = new ArrayList<>();
    }

    //metoda addProduct adauga un obiect Product in lista de produse a magazinului
    public void addProduct(Product product) {
        products.add(product);
    }

    //returenaza lista cyrenta de produse din magazin
    public ArrayList<Product> getProducts() {
        return products;
    }

    //elimina un produs specificat din lista de produse a magazinului
    public void removeProduct(Product product) {
        products.remove(product);
    }

    //sorteaza lista alfabetic dupa nume
    public void sortProductsByName() {
        Collections.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
    }

    //sorteaza dupa pret
    public void sortProductsByPrice() {
        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }
}