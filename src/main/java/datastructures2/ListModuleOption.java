package datastructures2;

import com.ethertons.None;
import com.ethertons.Option;
import com.ethertons.Some;

public class ListModuleOption {

    public static <T> Option<List<T>> list(Option<T> head, Option<List<T>> tail) {
        if (head.hasValue() && tail.hasValue()) {
            return new Some<List<T>>( new ListModuleOption.NonEmptyList<T>(head, tail)));
        } else {
            return new None<List<T>>();
        }
    }


//    static Option<String> wrap(String s) {
//        if (s == null)
//            return new None<String>();
//        else
//            return new Some<String>(s);
//    }


//    public static <T> List<T> list(T head, List<T> tail) {
//        return new NonEmptyList<T>(head, tail);
//    }

    public static interface List<T> {
        public abstract Option<T> head();
        public abstract Option<List<T>> tail();
    }

//    public static final class NonEmptyList<T> implements Option<List<T>> {

//        public Option<T>       head()    { return _head; }
//        public Option<List<T>> tail()    { return _tail; }
//        public boolean isEmpty() { return false; }
//
//        protected NonEmptyList(Option<T> head, Option<List<T>> tail) {
//            this._head = head;
//            this._tail = tail;
//        }
//
//        private final Option<T> _head;
//        private final Option<List<T>> _tail;
//
//
//        @Override
//        public boolean equals(Object other) {
//            if (other == null || getClass() != other.getClass())
//                return false;
//            List<?> that = (List<?>) other;
//            return head().equals(that.head()) && tail().equals(that.tail());
//        }
//
//        @Override
//        public int hashCode() { return 37*(head().hashCode()+tail().hashCode()); }
//
//        @Override
//        public String toString() { return "(" + head() + ", " + tail() + ")"; }



//    }


    private static class NonEmptyList implements List<T> {
        public NonEmptyList(Option<T> head, Option<List<T>> tail) {
        }

        @Override
        public Option<T> head() {
            return null;
        }

        @Override
        public Option<List<T>> tail() {
            return null;
        }
    }  }
}
