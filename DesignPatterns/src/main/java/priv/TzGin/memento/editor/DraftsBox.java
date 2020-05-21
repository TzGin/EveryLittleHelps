package priv.TzGin.memento.editor;

import java.util.Stack;

public class DraftsBox {

    private final Stack<ArticleMemento> STACK = new Stack<ArticleMemento>();

    public ArticleMemento getMemento() {
        return STACK.pop();
    }

    public void addMemento(ArticleMemento memento) {
        STACK.push(memento);
    }
}
