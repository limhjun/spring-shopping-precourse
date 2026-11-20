package shopping;

public class Product {
    private final String name;
    private final int price;
    private final String imageUrl;

    public Product(String name, int price, String imageUrl) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 15) {
            throw new IllegalArgumentException("상품 이름은 15자를 초과할 수 없습니다.");
        }
        if (!name.matches("[가-힣a-zA-Z0-9 ()\\[\\]+&/_-]+")) {
            throw new IllegalArgumentException("상품 이름에 허용되지 않은 문자가 포함되어 있습니다.");
        }
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
