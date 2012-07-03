package datastructures2;

public class OptionModule {

    public abstract class Option<T> {

        public abstract boolean hasValue();
        public abstract T get();
        public T getOrElse(T alternative) {
            return hasValue() == true ? get() : alternative;
        }
    }

    public class None<T> extends Option<T> {

        public None() {}
        public boolean hasValue() { return false; }
        public T get() { return null; }
        @Override
        public String toString() { return "None"; }
        @Override
        public boolean equals(Object other) {
            return (other == null || other.getClass() != None.class) ? false : true;
        }
        @Override
        public int hashCode() { return -1; }
    }

    public Option NONE = new Option() {
        @Override
        public boolean hasValue() {
            return false;
        }

        @Override
        public Object get() {
            return null;
        }
    };

    public final class Some<T> extends Option<T> {

        private final T value;

        public Some(T value) {
            this.value = value;
        }

        public boolean hasValue() {
            return true;
        }

        public T get() {
            return value;
        }

        @Override
        public String toString() {
            return "Some{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || other.getClass() != Some.class)
                return false;
            Some<?> that = (Some<?>) other;
            Object thatValue = that.get();
            return value.equals(thatValue);
        }

        @Override
        public int hashCode() {
            return 37 * value.hashCode();
        }
    }

}
