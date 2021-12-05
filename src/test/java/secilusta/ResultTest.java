package secilusta;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    private static Stream<Arguments> provideParamsForUniqueWolfs() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 3, 1), 1),
                Arguments.of(List.of(), -1)
        );
    }

    @NullAndEmptySource
    @ParameterizedTest
    void uniqueWolfsTest_emptyOrNull(List<Integer> list) {
        int result = Result.uniqueWolfs(list);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForUniqueWolfs")
    void uniqueWolfsTest(List<Integer> list, int expected) {
        int result = Result.uniqueWolfs(list);
        assertEquals(expected, result);
    }
}
