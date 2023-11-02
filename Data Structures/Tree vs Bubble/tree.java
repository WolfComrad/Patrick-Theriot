public class tree {
    int comparisons;
    treeNode root;

    void init() {
        root = null;
    }

    treeNode makeTreeNode(int d) {
        treeNode temp;
        temp = new treeNode();
        temp.data = d;
        temp.left = null;
        temp.right = null;
        temp.tracker = 0;
        return temp;
    }

    void buildSimpleTree(int numbers[]) {
        int j, num;
        int len = numbers.length;
        treeNode temp;
        boolean searching;

        init();

        comparisons = 0;

        for (j=0; j<len; j++) {
            num = numbers[j];
            if (j == 0) {
                root = makeTreeNode(num);
            }
            else {
                temp = root;
                searching = true;

                while (searching) {
                    if (num == temp.data) {
                        temp.tracker = temp.tracker + 1;
                        comparisons = comparisons + 1;
                        searching = false;
                    }
                    else if (num < temp.data) {
                        comparisons = comparisons + 2;
                        if (temp.left == null) {
                            temp.left = makeTreeNode(num);
                            
                            searching = false;
                        }
                        else {
                            temp = temp.left;
                        }
                    }
                    else if (num > temp.data) {
                        comparisons = comparisons + 3;
                        if (temp.right == null) {
                            temp.right = makeTreeNode(num);
                            
                            searching = false;
                        }
                        else {
                            temp = temp.right;
                        }
                    }
                }
            }
        }

        //;System.out.println("j = "+j);
    }

    void inOrder(treeNode temp) {
        if (temp.left != null) {
            inOrder(temp.left);
        }
        System.out.print(temp.data + " ");
        if (temp.right != null) {
            inOrder(temp.right);
        }
    }
}
