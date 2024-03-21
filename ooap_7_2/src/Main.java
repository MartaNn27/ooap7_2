// Базовий клас обробника
abstract class EditorHandler {
    protected EditorHandler successor;

    public void setSuccessor(EditorHandler successor) {
        this.successor = successor;
    }

    public abstract void processTask(Task task);
}

// Клас представлення завдання
class Task {
    private String description;
    private String responsible;

    public Task(String description, String responsible) {
        this.description = description;
        this.responsible = responsible;
    }

    public String getDescription() {
        return description;
    }

    public String getResponsible() {
        return responsible;
    }
}

// Клас редактора
class Editor extends EditorHandler {
    @Override
    public void processTask(Task task) {
        if (task.getResponsible().equals("Editor")) {
            System.out.println("Editor is processing task: " + task.getDescription());
        } else if (successor != null) {
            successor.processTask(task);
        } else {
            System.out.println("No one is available to handle the task.");
        }
    }
}

// Клас макетувальника
class LayoutDesigner extends EditorHandler {
    @Override
    public void processTask(Task task) {
        if (task.getResponsible().equals("Layout Designer")) {
            System.out.println("Layout Designer is processing task: " + task.getDescription());
        } else if (successor != null) {
            successor.processTask(task);
        } else {
            System.out.println("No one is available to handle the task.");
        }
    }
}

// Клас дизайнера
class Designer extends EditorHandler {
    @Override
    public void processTask(Task task) {
        if (task.getResponsible().equals("Designer")) {
            System.out.println("Designer is processing task: " + task.getDescription());
        } else if (successor != null) {
            successor.processTask(task);
        } else {
            System.out.println("No one is available to handle the task.");
        }
    }
}

// Клас клієнта для випробування
public class Main {
    public static void main(String[] args) {
        // Створення обробників
        Editor editor = new Editor();
        LayoutDesigner layoutDesigner = new LayoutDesigner();
        Designer designer = new Designer();

        // Встановлення послідовності ланцюга
        editor.setSuccessor(layoutDesigner);
        layoutDesigner.setSuccessor(designer);

        // Створення завдань
        Task task1 = new Task("Editing article", "Editor");
        Task task2 = new Task("Layout design for magazine", "Layout Designer");
        Task task3 = new Task("Designing cover page", "Designer");
        Task task4 = new Task("Proofreading content", "Proofreader");

        // Обробка завдань
        editor.processTask(task1);
        editor.processTask(task2);
        editor.processTask(task3);
        editor.processTask(task4);
    }
}
