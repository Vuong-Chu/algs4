public class Main {
    public static void main(String[] args){
        UnionFind uf = new UnionFind(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 3);

        System.out.println(uf.connected(0, 7));
        System.out.println(uf.connected(8, 9));
        System.out.println(uf.connected(5, 0));

        System.out.println("**** *********** ****");

        UnionFindLazy ufl = new UnionFindLazy(10);
        ufl.union(4, 3);
        ufl.union(3, 8);
        ufl.union(6, 5);
        ufl.union(9, 4);
        ufl.union(7, 2);
        ufl.union(6, 1);
        ufl.union(2, 1);
        ufl.union(5, 0);
        ufl.union(7, 3);

        System.out.println(ufl.connected(0, 7));
        System.out.println(ufl.connected(8, 9));
        System.out.println(ufl.connected(5, 0));

    }
}
