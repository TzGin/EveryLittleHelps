package priv.TzGin.memento.editor;

public class Test {
    public static void main(String[] args) {
        DraftsBox draftBox = new DraftsBox();

        Editor editor = new Editor("test", "balabala", ".jpg");
        ArticleMemento articleMemento = editor.saveToMemento();
        draftBox.addMemento(articleMemento);

        System.out.println("标题:" + editor.getTitle() + "\n" +
                            "内容:" + editor.getContent() + "\n" +
                            "插图:" + editor.getImgs() + "\n暂存成功");
        System.out.println("完整信息" + editor);

        System.out.println("===============首次修改文章==============");
        editor.setTitle("test2");
        editor.setContent("new balabala");

        System.out.println("==================首次修改完成==============");
        System.out.println("完整信息" + editor);

        System.out.println("==================保存到草稿箱==============");
        articleMemento = editor.saveToMemento();
        draftBox.addMemento(articleMemento);

        System.out.println("===============二次修改文章==============");
        editor.setTitle("test3");
        editor.setContent("new balabala2");
        editor.setImgs(".png");

        System.out.println("==================二次修改完成==============");
        System.out.println("完整信息" + editor);

        System.out.println("=============第1次撤销回退=============");
        articleMemento = draftBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息" + editor);

        System.out.println("=============第2次撤销回退=============");
        articleMemento = draftBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息" + editor);
    }
}
