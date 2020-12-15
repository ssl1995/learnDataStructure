package ssl.tree.segmentTree;

/**
 * @Author ssl
 * @Date 2020/12/15 10:10
 * @Description
 */
public interface Merger <E>{
    E merge(E a, E b);
}
