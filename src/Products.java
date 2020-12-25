public class Products {
    private String codeName;
    private String nameProducts;
    private int indexHead;
    private int indexFinal;

    public int getConsumption() {
        return this.getIndexFinal() - this.getIndexHead();
    }

    public Products() {
    }

    public Products(String codeName, String nameProducts, int indexHead, int indexFinal) {
        this.codeName = codeName;
        this.nameProducts = nameProducts;
        this.indexHead = indexHead;
        this.indexFinal = indexFinal;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public int getIndexHead() {
        return indexHead;
    }

    public void setIndexHead(int indexHead) {
        this.indexHead = indexHead;
    }

    public int getIndexFinal() {
        return indexFinal;
    }

    public void setIndexFinal(int indexFinal) {
        this.indexFinal = indexFinal;
    }

    @Override
    public String toString() {
        return "Products: " +
                "codeName: " + codeName + '\t' +
                ", nameProducts: " + nameProducts + '\t' +
                ", indexHead: " + indexHead + '\t' +
                ", indexFinal: " + indexFinal + '\n';
    }
}
