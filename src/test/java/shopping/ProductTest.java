package shopping;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {

    private static final int VALID_PRICE = 1000;
    private static final String VALID_IMAGE_URL = "https://example.com/a.png";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "       "})
    void 이름은_빈_문자열이거나_공백으로만_이루어질_수_없다(String name) {
        assertThatThrownBy(() -> new Product(name, VALID_PRICE, VALID_IMAGE_URL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 비어 있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1234567890123456",
            "12345678901234567",
            "123456789012345 6"
    })
    void 이름은_공백을_포함하여_15자를_초과할_수_없다(String name) {
        assertThatThrownBy(() -> new Product(name, VALID_PRICE, VALID_IMAGE_URL))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
