package priv.TzGin.composite.general.safe;

public class Test {

    public static void main(String[] args) {
        //根节点
        Composite root = new Composite("root");
        //树枝节点
        Composite branchA = new Composite("---branchA");
        Composite branchB = new Composite("------branchB");
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
