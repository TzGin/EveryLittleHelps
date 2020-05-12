package priv.TzGin.composite.demo.safe;

public class Test {

    public static void main(String[] args) {
        System.out.println("===============安全模式写法===============");

        File qq = new File("QQ.exe");
        File wx = new File("WeChat.exe");

        Folder office = new Folder("办公软件", 2);

        File word = new File("Word.exe");
        File excel = new File("Excel.exe");
        File ppt = new File("PowerPoint.exe");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("D盘", 1);

        root.add(qq);
        root.add(wx);
        root.add(office);

        System.out.println("===========show===========");
        root.show();
        System.out.println("===========list===========");
        root.list();
    }
}
