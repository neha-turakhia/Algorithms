package Utils;

import java.util.Arrays;

public class UnionFind {
    int total_size;
    int[] size;
    int[] id;
    int components_count;
    UnionFind(int inputsize){
        this.total_size = inputsize;
        size = new int[total_size];
        Arrays.fill(size,1);
        id = new int[total_size];
        for(int i=0;i<total_size;++i) {
            id[i] = i;
        }
        components_count = inputsize;
    }

    public int find(int input) {
        int root = input;
        while(id[root] != root) {
            root = id[root];
        }

        /*Path Compression*/
        while(id[input] != root) {
            int parent = id[input];
            id[input] = root;
            input = parent;
        }
        return root;
    }

    public void union(int p, int q) {
        int p_root = find(p);
        int q_root = find(q);

        if(p_root != q_root) {
            int psize = getComponentSize(p);
            int qsize = getComponentSize(q);

            if(psize > qsize) {
                id[q_root] = p_root;
                size[p] += qsize;
            }else {
                id[p_root] = q_root;
                size[q] += psize;
            }
            components_count--;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int getComponentSize(int p) {
        return size[p];
    }
}
