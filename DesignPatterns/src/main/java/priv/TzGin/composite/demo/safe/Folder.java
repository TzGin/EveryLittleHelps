package priv.TzGin.composite.demo.safe;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Directory {

    //表示树，不可控
//    private List<List<List<Folder>>> trees;

    private List<Directory> dirs;

    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<Directory>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory dir: dirs) {
            if (name != null) {
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }
                for (int i = 0; i < level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            dir.show();
        }
    }

    public boolean add(Directory dir) {
        return dirs.add(dir);
    }

    public boolean remove(Directory dir) {
        return dirs.remove(dir);
    }

    public Directory get(int index) {
        return dirs.get(index);
    }

    public void list() {
        for (Directory dir : dirs) {
            System.out.println(dir.name);
        }
    }
}
