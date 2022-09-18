import java.util.ArrayList;
import java.util.List;

public class TreeFun<T> {
    private T value;
    private List<TreeFun<T>> children;

    private TreeFun(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> TreeFun<T> of(T value) {
        return new TreeFun<>(value);
    }

    public TreeFun<T> addChild (T value) {
        TreeFun<T> newChild = new TreeFun<>(value);
        children.add(newChild);
        return newChild;
    }
}
