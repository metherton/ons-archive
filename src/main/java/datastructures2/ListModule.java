package datastructures2;

import com.ethertons.Option;

public class ListModule {

    public static interface List<T> {

        public abstract Option<T> head();
        public abstract List<T> tail();
        public abstract boolean isEmpty();
    }

    public static final class NonEmptyList<T> implements List<T> {

        public Option<T>       head()    { return _head; }
        public List<T> tail()    { return _tail; }
        public boolean isEmpty() { return false; }

        protected NonEmptyList(Option<T> head, List<T> tail) {
            this._head = head;
            this._tail = tail;
        }

        private final Option<T> _head;
        private final List<T> _tail;

        @Override
        public boolean equals(Object other) {
            if (other == null || getClass() != other.getClass())
                return false;
            List<?> that = (List<?>) other;
            return head().equals(that.head()) && tail().equals(that.tail());
        }

        @Override
        public int hashCode() { return 37*(head().hashCode()+tail().hashCode()); }

        @Override
        public String toString() { return "(" + head() + ", " + tail() + ")"; }
    }

    public static final List<? extends Object> EMPTY = new List<Object>() {

        public Option<Object> head()    { throw new EmptyListHasNoHead(); }
        public List<Object> tail()    { throw new EmptyListHasNoTail(); }
        public boolean      isEmpty() { return true; }

    };



    public static class EmptyListHasNoHead extends RuntimeException {}

    public static class EmptyListHasNoTail extends RuntimeException {}

    /* See the text for an explanation of this code */
    @SuppressWarnings(value = "unchecked")
    public static <T> List<T> emptyList() {
        return (List<T>) EMPTY; // Dangerous!?
    }

    public static <T> List<T> list(Option<T> head, List<T> tail) {
        return new NonEmptyList<T>(head, tail);
    }

}
