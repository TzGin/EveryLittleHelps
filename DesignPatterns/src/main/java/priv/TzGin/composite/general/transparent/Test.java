package priv.TzGin.composite.general.transparent;

public class Test {

    public static void main(String[] args) {
        //根节点
        Component root = new Composite("root");
        //树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");
        //叶子节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);

        branchA.addChild(leafA);
        branchA.addChild(branchB);

        branchB.addChild(leafB);

        System.out.println(root.operation());
    }
}
