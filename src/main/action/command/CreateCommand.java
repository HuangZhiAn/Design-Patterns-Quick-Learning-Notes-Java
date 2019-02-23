package action.command;

public class CreateCommand implements Command {
    private BoardScreen boardScreen = new BoardScreen();

    @Override
    public void execute() {
        boardScreen.create();
    }
}
