package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputStream standardIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test

    void 자동차_이름_형식이_올바르지_못하면_예외를_발생시킨다() {
        provideInput("pobi,,woni\n");
        assertThatThrownBy(InputView::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외를_발생시킨다() {
        provideInput("notNumber\n");
        assertThatThrownBy(InputView::inputTrialNumberCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
