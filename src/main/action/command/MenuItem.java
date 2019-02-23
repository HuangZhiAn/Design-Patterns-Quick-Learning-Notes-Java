package action.command;

public class MenuItem {
    private String name;

    private Command command;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click(){
        command.execute();
    }
}
