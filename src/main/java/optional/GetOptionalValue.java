package optional;
import java.util.NoSuchElementException;
import java.util.Optional;
/*
Finish the implementation of generateRandomOptional() and getOptionalValue() methods.

generateRandomOptional() should return Optional that holds randomNumber value -
if randomNumber is odd, or empty Optional - if randomNumber is even.

getOptionalValue() should call generateRandomOptional(), receive the Optional and return its value.
If there is no value present - it should throw NoSuchElementException.
 */
public class GetOptionalValue {
    public Integer getOptionalValue(int randomNumber) {
        Optional<Integer> optional = generateRandomOptional(randomNumber);
        optional.orElseThrow(NoSuchElementException::new);
        return optional.get();
    }

    public Optional<Integer> generateRandomOptional(int randomNumber) {
        if (randomNumber % 2 == 0) {
            return Optional.of(randomNumber);
        } else {
            return Optional.empty();
        }
    }
}
