package shopping;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
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

    @ParameterizedTest
    @ValueSource(strings = {
            "상품!",
            "상품@",
            "상품#",
            "상품$",
            "상품%",
            "상품*",
            "상품?"
    })
    void 이름에는_허용되지_않은_특수문자를_사용할_수_없다(String name) {
        assertThatThrownBy(() -> new Product(name, VALID_PRICE, VALID_IMAGE_URL))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "상품(대)",
            "상품[특가]",
            "상품+추가",
            "상품-할인",
            "상품&쿠폰",
            "상품/배송",
            "상품_이름"
    })
    void 이름에는_허용된_특수문자를_사용할_수_있다(String name) {
        assertThatCode(() -> new Product(name, VALID_PRICE, VALID_IMAGE_URL))
                .doesNotThrowAnyException();
    }
}
