package action.command;

public class EditCommand implements Command {
    private BoardScreen boardScreen = new BoardScreen();

    @Override
    public void execute() {
        boardScreen.edit();
    }
}
