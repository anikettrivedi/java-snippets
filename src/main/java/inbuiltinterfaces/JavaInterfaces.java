package inbuiltinterfaces;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class JavaInterfaces <T> {
    Serializable serializable;
    Comparable <T> comparable;
    CharSequence charSequence;
    Constable constable;
    ConstantDesc constantDesc;

    Collection<T> collection;
    Iterable<T> iterable;

    List<T> list;
    Set<T> set;
    Deque<T> deque;
    Cloneable cloneable;
}
