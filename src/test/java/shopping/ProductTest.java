package shopping;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {

    private static final int VALID_PRICE = 1000;
    private static final String VALID_IMAGE_URL = "https://example.com/a.png";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "       "})
    void 이름은_빈_문자열이거나_공백으로만_이루어질_수_없다(String name) {
        Assertions.assertThatThrownBy(() -> new Product(name, VALID_PRICE, VALID_IMAGE_URL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 비어 있을 수 없습니다.");
    }
}
