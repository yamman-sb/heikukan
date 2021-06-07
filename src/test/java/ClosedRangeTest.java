import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("閉区間を持つクラス")
class ClosedRangeTest {

  @Nested
  class 整数閉区間の文字列表記を返せる {
    @Test
    @DisplayName("下端点3、上端点7を渡した場合、文字列[3,7]が帰ってくる")
    void toStringMin3Max7() {
      Range closedRange = new ClosedRange(3,7);
      assertEquals(closedRange.toString(), "[3,7]");
    }
  }

  @Nested
  class 整数閉区間が整数を含むかどうかを判定する {
    @Nested
    class 下端点が3上端点が7のとき {
      private Range closedRange;

      @BeforeEach
      void setup() {
        closedRange = new ClosedRange(3, 7);
      }

      @Test
      void 整数7を渡すとtrueが帰ってくることを判定する() {
        assertTrue(closedRange.isIncluded(7));
      }

      @Test
      void 整数8を渡すとfalseが帰ってくることを判定する() {
        assertFalse(closedRange.isIncluded(8));
      }

      @Test
      void 整数3を渡すとtrueが帰ってくることを判定する()  {
        assertTrue(closedRange.isIncluded(3));
      }

      @Test
      void 整数2を渡すとfalseが帰ってくることを判定する() {
        assertFalse(closedRange.isIncluded(2));
      }
    }
  }

  @Nested
  class 下端が上端より大きい場合は例外を発生させる {
    @Test
    void 下端点3上端点2で作成した場合例外が発生する() {
      assertThrows(
          IllegalArgumentException.class, () -> {new ClosedRange(3,2);}
      );
    }

    @Test
    void 下端点3上端点3で作成した場合例外は発生しない() {
      assertDoesNotThrow(
          () -> {new ClosedRange(3,3);}
      );
    }
  }
}